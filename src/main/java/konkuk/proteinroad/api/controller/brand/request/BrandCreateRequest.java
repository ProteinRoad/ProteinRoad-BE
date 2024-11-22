package konkuk.proteinroad.api.controller.brand.request;

import jakarta.validation.constraints.NotEmpty;
import konkuk.proteinroad.api.service.brand.request.BrandCreateServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandCreateRequest {

    @NotEmpty(message = "브랜드명은 필수입니다.")
    private String name;

    public BrandCreateServiceRequest toServiceRequest() {
        return BrandCreateServiceRequest.builder()
                .name(name)
                .build();
    }
}
