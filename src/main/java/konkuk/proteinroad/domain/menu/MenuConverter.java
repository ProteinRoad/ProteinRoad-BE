package konkuk.proteinroad.domain.menu;

import konkuk.proteinroad.api.service.menu.request.MenuCreateServiceRequest;
import konkuk.proteinroad.api.service.menu.response.MenuDto;

public class MenuConverter {
    public static Menu toEntity(MenuCreateServiceRequest request) {
        return Menu.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .protein(request.getProtein())
                .carbohydrate(request.getCarbohydrate())
                .fat(request.getFat())
                .calorie(request.getCalorie())
                .sodium(request.getSodium())
                .build();
    }

    public static MenuDto dtoOf(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .description(menu.getDescription())
                .protein(menu.getProtein())
                .carbohydrate(menu.getCarbohydrate())
                .fat(menu.getFat())
                .calorie(menu.getCalorie())
                .sodium(menu.getSodium())
                .build();
    }
}
