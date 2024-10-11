package konkuk.proteinroad.domain.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import konkuk.proteinroad.domain.base.BaseEntity;
import konkuk.proteinroad.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    private String imageUrl;

    @OneToMany(mappedBy = "store")
    private List<Menu> menus;
}
