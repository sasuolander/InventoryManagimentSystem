package InventorySystem.Repository;

import InventorySystem.Object.Order;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// JPA KeyWord system, findBy,countBy,deleteBy,removeBy,


// Custom way to make query
@Repository
public interface OrderRepository extends MyBaseRepository<Order, Long> {
    //Order findById(ID id);
    Order findByTitle(String title);
    Order findByfirstName(String firtName);
    Order findBylastName(String lastName);
    Order findByNumberShipped(int shipped);
    Order findByOrderDate(Date date);
}
