package inventorysystem.repository;
import inventorysystem.object.Suppliers;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends MyBaseRepository<Suppliers, Long>  {
    //Suppliers findById(ID id);
}
