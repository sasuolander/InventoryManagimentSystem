package inventorysystem.repository;
import inventorysystem.object.entity.Order;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.Optional;

// JPA KeyWord system, findBy,countBy,deleteBy,removeBy,
// Custom way to make query
@Repository
public interface OrderRepository extends MyBaseRepository<Order, Long> {
    long deleteByOrderId(String id);

    Optional<Order> findByOrderId(String Id);
    Optional<Order> findByTitle(String title);
    Optional<Order> findByFirstName(String firstName);
    Optional<Order> findByLastName(String lastName);
    Optional<Order> findByNumberShipped(int shipped);
    Optional<Order> findByOrderDate(Date date);
}
