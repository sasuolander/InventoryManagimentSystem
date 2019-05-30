package inventorysystem.service;

import inventorysystem.object.Order;
import inventorysystem.repository.OrderRepository;
import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIml implements BasicService<Order>{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceIml(OrderRepository orderRepository){
        this.orderRepository =  orderRepository;
    }

    public Optional<Order> findById(Long id) {
        return
                orderRepository.findById(id);
    }
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public boolean save(Order order) {
        try
        {
            orderRepository.save(order);
            return true;
        } catch (CacheException e) { return false;}
    }

    public boolean delete(Long id) {
        orderRepository.deleteById(id);
        return true;
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
    //https://www.callicoder.com/java-8-optional-tutorial/
    public boolean update(Order order) {
        Optional<Order> oldOrder = orderRepository.findById(order.getOrderId());
        if (!oldOrder.isPresent()){return false;}
        orderRepository.save(order);
        return true;
    }
}
