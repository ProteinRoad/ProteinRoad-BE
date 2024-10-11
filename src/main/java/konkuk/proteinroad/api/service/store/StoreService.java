package konkuk.proteinroad.api.service.store;

import java.util.Collections;
import konkuk.proteinroad.api.service.store.dto.StoreDto;
import konkuk.proteinroad.domain.store.Store;
import konkuk.proteinroad.domain.store.StoreRepository;
import konkuk.proteinroad.global.exception.RestApiException;
import konkuk.proteinroad.global.exception.errorCode.store.StoreErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreDto findStoreBy(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RestApiException(StoreErrorCode.STORE_NOT_FOUND));

        store.sortMenus();
        return StoreDto.of(store);
    }
}