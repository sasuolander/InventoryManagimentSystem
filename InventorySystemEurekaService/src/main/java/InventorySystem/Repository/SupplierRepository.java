package inventorysystem.repository;
import inventorysystem.object.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends MyBaseRepository<Supplier, Long>  {
    long deleteBySupplierId(String id);
    Optional<Supplier> findBySupplierId(String Id);
}
