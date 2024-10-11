package konkuk.proteinroad.api.service.store.dto;

import java.util.List;
import konkuk.proteinroad.domain.menu.Menu;
import konkuk.proteinroad.domain.store.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreDto {

    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    private String imageUrl;

    private List<Menu> menus;

    @Builder
    private StoreDto(Long id, String name, Float latitude, Float longitude, String imageUrl,
            List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.menus = menus;
    }

    public static StoreDto of(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .imageUrl(store.getImageUrl())
                .menus(store.getMenus())
                .build();
    }
}
