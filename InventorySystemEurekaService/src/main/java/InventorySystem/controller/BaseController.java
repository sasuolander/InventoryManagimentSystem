package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import org.springframework.http.HttpStatus;

/**
 * T is for a entity class and P for an pojo class, You get your payload as pojo and then you translate it Entity class.
 * @param <T>
 * @param <P>
 */

public interface BaseController<T,P> {
    T findById(Long id) throws NotFoundException;
      HttpStatus save(P p);
    boolean delete(Long id);
    T update(P p) throws NotFoundException;
}
