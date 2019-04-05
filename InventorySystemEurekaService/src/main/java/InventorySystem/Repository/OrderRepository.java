package InventorySystem.Repository;
import InventorySystem.Object.Order;
import org.springframework.stereotype.Repository;
import java.util.Date;

// JPA KeyWord system, findBy,countBy,deleteBy,removeBy,
// Custom way to make query
@Repository
public interface OrderRepository extends MyBaseRepository<Order, Long> {

    @Override
    Order findById(Long id);

    Order findByTitle(String title);
    Order findByFirstName(String firstName);
    Order findByLastName(String lastName);
    Order findByNumberShipped(int shipped);
    Order findByOrderDate(Date date);
}
