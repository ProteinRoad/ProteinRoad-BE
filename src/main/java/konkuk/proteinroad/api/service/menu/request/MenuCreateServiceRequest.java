package konkuk.proteinroad.api.service.menu.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuCreateServiceRequest {

    private String name;

    private Integer price;

    private String description;

    private Integer protein;

    private Integer carbohydrate;

    private Integer fat;

    private Integer calorie;

    private Integer sodium;

    private Long brandId;

    @Builder
    public MenuCreateServiceRequest(String name, Integer price, String description, Integer protein,
            Integer carbohydrate, Integer fat, Integer calorie, Integer sodium, Long brandId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
        this.sodium = sodium;
        this.brandId = brandId;
    }
}
