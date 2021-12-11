package inventorysystem.service;

import inventorysystem.object.entity.Order;
import inventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Optional;

public abstract class BasicServiceImpl<T> implements BasicService<T> {

    /// find repository
    // register needed repository


    public Optional<T> findById(Long id) {
        return Optional.empty();
    }

    public T save(T entity) {
        return null;
    }

    public boolean delete(String id) {
        return false;
    }

    public boolean update(T object) {
        return false;
    }

    public Iterable<T> findAll() {
        return null;
    }

    public Iterable<T> findAllPage(int pages, int size) {
        return null;
    }
}


/*
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
    }*/
