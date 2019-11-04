package inventorysystem.service;

import inventorysystem.object.entity.Order;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface BasicService<T> {
    Optional<T> findById(Long id);
    T save(T entity);
     boolean delete(String id);
     boolean update(T object);
     Iterable<T> findAll();
    public Iterable<Order> findAllPage(int pages, int size);
}
