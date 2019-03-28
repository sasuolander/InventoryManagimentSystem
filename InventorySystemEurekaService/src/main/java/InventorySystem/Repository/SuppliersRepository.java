package InventorySystem.Repository;

import InventorySystem.Object.Suppliers;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

@Repository
interface SuppliersRepository extends MyBaseRepository<Suppliers, Long>  {
    //Suppliers findById(ID id);
}
