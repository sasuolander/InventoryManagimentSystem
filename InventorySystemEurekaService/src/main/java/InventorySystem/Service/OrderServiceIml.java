package inventorysystem.service;

import inventorysystem.object.Order;
import inventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceIml implements BasicService<Order>{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceIml(OrderRepository orderRepository){
        this.orderRepository =  orderRepository;
    }

    public Optional<Order> findById(Long id) {
        return  orderRepository.findById(id);
    }

    public <S extends Order> S save(S order) {
        orderRepository.save(order);
        return null;
    }

    public boolean delete(Long id) {
        orderRepository.deleteById(id);
        return orderRepository.findById(id).isPresent();
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
    public Optional<Order> update(Order order) {
        //Order OldOrder = orderRepository.findById(order.getOrderId()).ifPresent(order1 -> return order);
        //orderRepository.save(OldOrder);
        return Optional.empty();
    }
}
