package InventorySystem.Repository;

import InventorySystem.Object.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MyBaseRepository<Product, Long>  {
     //Product findById(ID id);
}
