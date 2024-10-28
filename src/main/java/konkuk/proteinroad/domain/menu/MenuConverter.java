package konkuk.proteinroad.domain.menu;

import konkuk.proteinroad.api.service.menu.request.MenuCreateServiceRequest;

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
}
