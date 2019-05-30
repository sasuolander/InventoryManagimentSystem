package inventorysystem.controller;

import java.util.Optional;

public interface BaseController<T> {
    T findById(Long id);
    <S extends T> S save(S entity);
    boolean delete(Long id);
    T update(T object);
}
