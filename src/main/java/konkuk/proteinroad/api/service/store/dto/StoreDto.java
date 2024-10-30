package konkuk.proteinroad.api.service.store.dto;

import java.util.List;
import konkuk.proteinroad.domain.menu.Menu;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreDto {

    private final Long id;

    private final String name;

    private final Float latitude;

    private final Float longitude;

    @Builder
    private StoreDto(Long id, String name, Float latitude, Float longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
