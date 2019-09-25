package main.repository;

import main.object.entityobject.UserEntity;

public interface UserRepository extends MyBaseRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
