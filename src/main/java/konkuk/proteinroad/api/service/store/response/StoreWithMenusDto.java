package konkuk.proteinroad.api.service.store.response;

import java.util.List;
import konkuk.proteinroad.api.service.menu.response.MenuDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreWithMenusDto {

    private final Long id;
    private final String name;
    private final Float latitude;
    private final Float longitude;
    private final List<MenuDto> menus;

    @Builder
    private StoreWithMenusDto(Long id, String name, Float latitude, Float longitude,
            List<MenuDto> menus) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.menus = menus;
    }
}
