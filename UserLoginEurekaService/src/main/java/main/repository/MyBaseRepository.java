package main.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepository <T, ID extends Serializable> extends Repository<T, ID> {
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    <S extends T> S save(S entity);
    <S extends T> S saveAndFlush(S entity);
    <S extends T> List<S> saveAll(Iterable<S> entities);
    void deleteById(ID id);

}