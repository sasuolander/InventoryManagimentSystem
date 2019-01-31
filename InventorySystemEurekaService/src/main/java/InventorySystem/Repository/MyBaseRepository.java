package InventorySystem.Repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition-tuning
// this is custom master Repository, programmer need to explicitly expose JPA functionalities or write custom method

@NoRepositoryBean
interface MyBaseRepository <T, ID extends Serializable> extends Repository<T, ID> {


    Optional<T> findById(ID id);

    default <S extends T> S save(S entity) {
        return null;
    }

}
