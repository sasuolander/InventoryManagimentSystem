package inventorysystem.repository;
import inventorysystem.object.entity.Purchase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends MyBaseRepository<Purchase, Long>  {
    long deleteByPurchaseId(String id);
    Optional<Purchase> findByPurchaseId(String Id);
}
