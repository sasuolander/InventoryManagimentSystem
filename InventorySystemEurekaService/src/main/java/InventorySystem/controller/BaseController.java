package inventorysystem.controller;

import inventorysystem.ExceptionHandeling.NotFoundException;
import inventorysystem.object.OrderPOJO;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface BaseController<T,P> {
    T findById(Long id) throws NotFoundException;
      HttpStatus save(P p);
    boolean delete(Long id);
    T update(P p);
}
