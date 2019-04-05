package InventorySystem.Repository;
import InventorySystem.Object.Suppliers;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends MyBaseRepository<Suppliers, Long>  {
    //Suppliers findById(ID id);
}
