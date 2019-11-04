package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

/**
 * T is for a entity class and P for an pojo class, You get your payload as pojo and then you translate it entity class.
 * @param <T>
 * @param <P>
 */

public interface BaseController<T,P> {
    T findById(String id) throws NotFoundException;
      HttpStatus save(P p);
    boolean delete(String id);
    T update(P p) throws NotFoundException;
    Iterable<T> findAll() throws NotFoundException;
    Iterable<T> findAllPaginationSorting(int pageNumber,int pageSize) throws NotFoundException;
}
