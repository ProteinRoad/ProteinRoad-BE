package konkuk.proteinroad.api.service.store.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreCreateServiceRequest {

    private String name;

    private Float latitude;

    private Float longitude;

    private Long brandId;

    @Builder
    public StoreCreateServiceRequest(String name, Float latitude, Float longitude,
            Long brandId) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.brandId = brandId;
    }
}
