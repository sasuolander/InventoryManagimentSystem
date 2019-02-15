package InventorySystem.Repository;

import InventorySystem.Object.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


// Custom way to make query
@Repository
public interface OrderRepository extends MyBaseRepository<Order, Long> {
}
