package inventorysystem.repository;

import inventorysystem.object.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MyBaseRepository<Product, Long>  {
     //Product findById(ID id);
}
