package InventorySystem.Repository;

import InventorySystem.Object.Product;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

@Repository
interface ProductRepository extends MyBaseRepository<Product, Long>  {
     //Product findById(ID id);
}
