package konkuk.proteinroad.api.controller.menu.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import konkuk.proteinroad.api.service.menu.request.MenuCreateServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuCreateRequest {

    @NotEmpty(message = "메뉴명은 필수입니다.")
    private String name;

    @Positive(message = "메뉴가격은 필수입니다.")
    private Integer price;

    private String description;

    @NotEmpty(message = "단백질 함유량은 필수입니다.")
    private Integer protein;

    @NotEmpty(message = "탄수화물 함유량은 필수입니다.")
    private Integer carbohydrate;

    @NotEmpty(message = "지뱡 함유량은 필수입니다.")
    private Integer fat;

    @NotEmpty(message = "칼로리 정보는 필수입니다.")
    private Integer calorie;

    @NotEmpty(message = "나트륨 함유량은 필수입니다.")
    private Integer sodium;

    @Positive(message = "브랜드 정보는 필수입니다.")
    private Long brandId;

    public MenuCreateServiceRequest toServiceRequest() {
        return MenuCreateServiceRequest.builder()
                .name(name)
                .price(price)
                .description(description)
                .protein(protein)
                .carbohydrate(carbohydrate)
                .fat(fat)
                .calorie(calorie)
                .sodium(sodium)
                .brandId(brandId)
                .build();
    }
}
