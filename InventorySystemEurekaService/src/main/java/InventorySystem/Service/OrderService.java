package inventorysystem.service;

import inventorysystem.object.Order;
import inventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements BasicService<Order>{
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository =  orderRepository;
    }

    public Optional<Order> findById(Long id) {
        Optional<Order>order= orderRepository.findById(id);
        return  order;
    }

    public <S extends Order> S save(S order) {
        orderRepository.save(order);
        return null;
    }

    public boolean delete(Long id) {
        orderRepository.deleteById(id);
        return orderRepository.findById(id).isPresent();
    }

    public Optional<Order> update(Order order) {
        Order OldOrder = orderRepository.findById(order.getOrderId()).get();
        orderRepository.save(OldOrder);
        return Optional.empty();
    }
}
