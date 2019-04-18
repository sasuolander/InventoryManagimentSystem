package inventorysystem.service;

import java.util.Optional;

public interface BasicService<T> {
    Optional<T> findById(Long id);
    <S extends T> S save(S entity);
     boolean delete(Long id);
     Optional<T> update(T object);
}
