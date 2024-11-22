package konkuk.proteinroad.api.controller.store.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import konkuk.proteinroad.api.service.store.request.StoreCreateServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreCreateRequest {
    @NotEmpty(message = "매장명은 필수입니다.")
    private String name;

    @NotEmpty(message = "위도 정보는 필수입니다.")
    private Float latitude;

    @NotEmpty(message = "경도 정보는 필수입니다.")
    private Float longitude;

    @Positive(message = "브랜드 정보는 필수입니다.")
    private Long brandId;

    public StoreCreateServiceRequest toServiceRequest() {
        return StoreCreateServiceRequest.builder()
                .name(name)
                .latitude(latitude)
                .longitude(longitude)
                .brandId(brandId)
                .build();
    }
}
