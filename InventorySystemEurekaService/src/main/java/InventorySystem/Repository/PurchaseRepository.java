package inventorysystem.repository;
import inventorysystem.object.entity.Purchase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends MyBaseRepository<Purchase, Long>  {
    //Purchaces findById(ID);
    Optional<Purchase> findByPurchaseId(Long Id);
}
