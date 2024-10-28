package konkuk.proteinroad.domain.menu;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import konkuk.proteinroad.domain.base.BaseEntity;
import konkuk.proteinroad.domain.brand.Brand;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String description;

    private Integer protein;

    private Integer carbohydrate;

    private Integer fat;

    private Integer calorie;

    private Integer sodium;

    private String imageKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brand", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Brand brand;

    @Builder
    private Menu(String name, Integer price, String description, String imageKey, Integer protein,
            Integer carbohydrate, Integer fat, Integer calorie, Integer sodium, Brand brand) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
        this.sodium = sodium;
        this.brand = brand;
        this.imageKey = imageKey;
    }

    public void registerImage(String imageKey) {
        this.imageKey = imageKey;
    }
    public void registerBrand(Brand brand) {
        this.brand = brand;
    }
}
