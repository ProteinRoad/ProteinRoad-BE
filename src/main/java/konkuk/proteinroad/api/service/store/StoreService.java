package konkuk.proteinroad.api.service.store;

import konkuk.proteinroad.api.service.store.response.FindAllStoreWithMenuResponse;
import konkuk.proteinroad.api.service.store.response.StoreDto;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;

public interface StoreService {

    StoreDto findStoreBy(Long storeId);
    Long createStore(StoreCreateServiceRequest request);
    FindAllStoreWithMenuResponse findAllStoresWithMenus();
}