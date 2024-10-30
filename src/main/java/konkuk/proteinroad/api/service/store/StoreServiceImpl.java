package konkuk.proteinroad.api.service.store;

import static konkuk.proteinroad.global.exception.errorCode.brand.BrandErrorCode.BRAND_NOT_FOUND;
import static konkuk.proteinroad.global.exception.errorCode.store.StoreErrorCode.*;

import java.util.List;
import java.util.stream.Collectors;
import konkuk.proteinroad.api.service.store.response.FindAllStoreWithMenuResponse;
import konkuk.proteinroad.api.service.store.response.StoreDto;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;
import konkuk.proteinroad.api.service.store.response.StoreWithMenusDto;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.brand.BrandRepository;
import konkuk.proteinroad.domain.menu.MenuConverter;
import konkuk.proteinroad.domain.store.Store;
import konkuk.proteinroad.domain.store.StoreConverter;
import konkuk.proteinroad.domain.store.StoreRepository;
import konkuk.proteinroad.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final BrandRepository brandRepository;

    @Transactional(readOnly = true)
    public StoreDto findStoreBy(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RestApiException(STORE_NOT_FOUND.getErrorCode()));

        return StoreConverter.dtoOf(store);
    }

    @Transactional(readOnly = true)
    public FindAllStoreWithMenuResponse findAllStoresWithMenus() {
        List<Store> stores = storeRepository.findAllBrandIdsByStores();

        return FindAllStoreWithMenuResponse.builder()
                .storeWithMenusDtoList(createStoreWithMenusDtoList(stores))
                .build();
    }


    public Long createStore(StoreCreateServiceRequest request) {
        Brand brand = brandRepository.findById(request.getBrandId())
                .orElseThrow(() -> new RestApiException(BRAND_NOT_FOUND.getErrorCode()));
        Store store = StoreConverter.toEntity(request);
        store.registerBrand(brand);

        return storeRepository.save(store).getId();
    }

    private List<StoreWithMenusDto> createStoreWithMenusDtoList(List<Store> stores) {
        return stores.stream()
                .map(store -> StoreWithMenusDto.builder()
                        .id(store.getId())
                        .name(store.getName())
                        .latitude(store.getLatitude())
                        .longitude(store.getLongitude())
                        .menus(store.getMenus().stream()
                                .map(MenuConverter::dtoOf)
                                .collect(Collectors.toList())
                        ).build())
                .collect(Collectors.toList());
    }
}