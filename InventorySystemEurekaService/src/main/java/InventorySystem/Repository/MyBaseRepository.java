package inventorysystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition-tuning
// this is custom master Repository, Write here general query and specific query in domain repository
// JPA KeyWord system, findBy,countBy,deleteBy,removeBy,
@NoRepositoryBean
interface MyBaseRepository <T, ID extends Serializable> extends Repository<T, ID>{
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    Page<T> findAll(Pageable pageable);
    Iterable<T> findAll(Sort sort);
     <S extends T> S save(S entity);
     <S extends T> S saveAndFlush(S entity);
     <S extends T> List<S> saveAll(Iterable<S> entities);
     void deleteById(ID id);
}
