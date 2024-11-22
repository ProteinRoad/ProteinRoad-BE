package konkuk.proteinroad.api.service.menu.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuDto {

    private final Long id;
    private final String name;
    private final Integer price;
    private final String description;
    private final Integer protein;
    private final Integer carbohydrate;
    private final Integer fat;
    private final Integer calorie;
    private final Integer sodium;
    private final String imageUrl;

    @Builder
    private MenuDto(Long id, String name, Integer price, String description, Integer protein,
            Integer carbohydrate, Integer fat, Integer calorie, Integer sodium, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
        this.sodium = sodium;
        this.imageUrl = imageUrl;
    }
}
