package konkuk.proteinroad.api.service.brand.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BrandCreateServiceRequest {

    private String name;

    @Builder
    public BrandCreateServiceRequest(String name) {
        this.name = name;
    }
}
