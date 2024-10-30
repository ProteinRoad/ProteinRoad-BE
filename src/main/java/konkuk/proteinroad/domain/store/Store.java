package konkuk.proteinroad.domain.store;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import konkuk.proteinroad.domain.base.BaseEntity;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Builder;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brand_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Brand brand;

    @Builder
    private Store(String name, Float latitude, Float longitude, String imageUrl, Brand brand) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.brand = brand;
    }

    public void registerBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Menu> getMenus() {
        return brand.getMenus();
    }
}
