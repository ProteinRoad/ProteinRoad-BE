package konkuk.proteinroad.domain.store;

import konkuk.proteinroad.api.service.store.response.StoreDto;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;

public class StoreConverter {
    public static StoreDto dtoOf(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .build();
    }

    public static Store toEntity(StoreCreateServiceRequest request) {
        return Store.builder()
                .name(request.getName())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }
}
