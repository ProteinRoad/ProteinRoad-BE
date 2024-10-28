package konkuk.proteinroad.api.service.store;

import konkuk.proteinroad.api.service.store.dto.StoreDto;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;

public interface StoreService {

    StoreDto findStoreBy(Long storeId);
    Long createStore(StoreCreateServiceRequest request);
}