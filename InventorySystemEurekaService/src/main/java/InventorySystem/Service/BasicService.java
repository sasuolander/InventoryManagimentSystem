package inventorysystem.service;


import java.util.Optional;

public interface BasicService<T> {
    Optional<T> findById(Long id);
    T save(T entity);
     boolean delete(String id);
     boolean update(T object);
     Iterable<T> findAll();
     Iterable<T> findAllPage(int pages, int size);
}
