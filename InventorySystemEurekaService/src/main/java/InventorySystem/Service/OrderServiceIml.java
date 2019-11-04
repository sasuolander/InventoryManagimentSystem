package inventorysystem.service;

import inventorysystem.object.entity.Order;
import inventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceIml implements BasicService<Order>{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceIml(OrderRepository orderRepository){
        this.orderRepository =  orderRepository;
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
    public Optional<Order> findByOrderId(String id) {
        return orderRepository.findByOrderId(id);
    }
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
    public Iterable<Order> findAllPage( int numberPage,int size) {

        Pageable pageConfig= PageRequest.of(numberPage,size);
        return orderRepository.findAll(pageConfig);
    }

    public Order save(Order order) {
        Order SavedOrder =orderRepository.save(order);
            return SavedOrder;
    }
    @Transactional
    public boolean delete(String id) {
        orderRepository.deleteByOrderId(id);
        return true;
    }

    public boolean update(Order order) {
        Optional<Order> oldOrder = orderRepository.findByOrderId(order.getOrderId());
        if (!oldOrder.isPresent()){return false;}
        orderRepository.save(order);
        return true;
    }
}
