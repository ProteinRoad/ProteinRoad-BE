package konkuk.proteinroad.api.service.cache;


import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import konkuk.proteinroad.api.service.file.FileService;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.store.Store;
import konkuk.proteinroad.domain.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageUrlCacheService implements CacheService {

    private final FileService s3Service;
    private final RedisTemplate<String, String> redisTemplate;
    private final StoreRepository storeRepository;
    private final Executor cacheUpdateExecutor;

    @Scheduled(cron = "0 0 3 * * *")
    @Async("cacheUpdateExecutor")
    protected void updateImageUrlCache() {
        List<Store> stores = storeRepository.findAllBrandIdsByStores();
        Map<Long, Brand> brands = stores.stream()
                .map(Store::getBrand)
                .distinct()
                .collect(Collectors.toMap(Brand::getId, brand -> brand));

        List<CompletableFuture<Void>> futures = brands.values().stream()
                .map(brand-> CompletableFuture.runAsync(() -> {
                    String brandImageKey = brand.getImageKey();
                    if (brandImageKey != null && !brandImageKey.isEmpty()) {
                        String brandImagePreSignedUrl = s3Service.getFileUrl(brandImageKey);
                        redisTemplate.opsForValue()
                                .set(brandImageKey, brandImagePreSignedUrl, 25, TimeUnit.HOURS);
                    }

                    brand.getMenus().forEach(menu -> {
                        String menuImageKey = menu.getImageKey();
                        if (menuImageKey != null && !menuImageKey.isEmpty()) {
                            String menuImagePreSignedUrl = s3Service.getFileUrl(menuImageKey);
                            redisTemplate.opsForValue()
                                    .set(menuImageKey, menuImagePreSignedUrl, 25, TimeUnit.HOURS);
                        }
                    });
                }, cacheUpdateExecutor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    public String getImageUrl(String key) {
        String cachedUrl = redisTemplate.opsForValue().get(key);
        if (cachedUrl == null) {
            cachedUrl = s3Service.getFileUrl(key);
            redisTemplate.opsForValue().set(key, cachedUrl, 2, TimeUnit.HOURS);
        }
        return cachedUrl;
    }
}
