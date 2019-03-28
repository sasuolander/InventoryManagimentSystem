package InventorySystem.Repository;

import InventorySystem.Object.Order;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


// Custom way to make query
@Repository
public interface OrderRepository extends MyBaseRepository<Order, Long> {
    //Order findById(ID id);
}
