package inventorysystem.repository;

import inventorysystem.object.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MyBaseRepository<Product, Long>  {
     long deleteByProductId(String id);
     Optional<Product> findByProductId(String Id);
}
