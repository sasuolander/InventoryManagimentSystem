package inventorysystem.repository;
import inventorysystem.object.entity.Purchases;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends MyBaseRepository<Purchases, Long>  {
    //Purchaces findById(ID);
}
