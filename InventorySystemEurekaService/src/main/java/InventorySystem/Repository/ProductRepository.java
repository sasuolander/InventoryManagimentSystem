package inventorysystem.repository;

import inventorysystem.object.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MyBaseRepository<Product, Long>  {
     //Product findById(ID id);
     Optional<Product> findByProductId(Long Id);
}
