package InventorySystem.Repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition-tuning
// this is custom master Repository, Write here general query and specific query in domain repository
// JPA KeyWord system, findBy,countBy,deleteBy,removeBy,
@NoRepositoryBean
interface MyBaseRepository <T, ID extends Serializable> extends Repository<T, ID> {
    T findById(ID id);
    Optional<T> findAll();

    default <S extends T> S save(S entity) { return null; }
    default <S extends T> List<S> saveAll(Iterable<S> entities){return null;}
    default void deleteById(ID id){}
}
