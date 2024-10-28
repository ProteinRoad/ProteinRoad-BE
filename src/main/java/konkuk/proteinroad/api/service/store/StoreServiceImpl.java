package konkuk.proteinroad.api.service.store;

import static konkuk.proteinroad.global.exception.errorCode.brand.BrandErrorCode.BRAND_NOT_FOUND;
import static konkuk.proteinroad.global.exception.errorCode.store.StoreErrorCode.*;

import konkuk.proteinroad.api.service.store.dto.StoreDto;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.brand.BrandRepository;
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

    public Long createStore(StoreCreateServiceRequest request) {
        Brand brand = brandRepository.findById(request.getBrandId())
                .orElseThrow(() -> new RestApiException(BRAND_NOT_FOUND.getErrorCode()));
        Store store = StoreConverter.toEntity(request);
        store.registerBrand(brand);

        return storeRepository.save(store).getId();
    }
}