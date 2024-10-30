package konkuk.proteinroad.domain.store;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select s from Store s "
            + "join fetch s.brand b")
    List<Store> findAllBrandIdsByStores();
}
