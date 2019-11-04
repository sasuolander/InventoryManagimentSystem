package inventorysystem.repository;
import inventorysystem.object.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends MyBaseRepository<Supplier, Long>  {
    //Supplier findById(ID id);
    Optional<Supplier> findBySupplierId(Long Id);
}
