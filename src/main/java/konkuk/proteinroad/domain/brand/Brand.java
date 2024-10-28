package konkuk.proteinroad.domain.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import konkuk.proteinroad.domain.base.BaseEntity;
import konkuk.proteinroad.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageKey;

    @OneToMany(mappedBy = "brand")
    private List<Menu> menus;

    @Builder
    private Brand(String name, String imageKey) {
        this.name = name;
        this.imageKey = imageKey;
        this.menus = new ArrayList<>();
    }

    public static Brand create(String name, String imageKey) {
        return Brand.builder()
                .name(name)
                .imageKey(imageKey)
                .build();
    }
}
