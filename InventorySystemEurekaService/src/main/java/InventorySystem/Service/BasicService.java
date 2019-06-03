package inventorysystem.service;

import java.util.Optional;

public interface BasicService<T> {
    Optional<T> findById(Long id);
    T save(T entity);
     boolean delete(Long id);
     boolean update(T object);
     Iterable<T> findAll();
}
