package main.service;

import main.object.dtoobject.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


interface UserServiceInterface extends UserDetailsService {
    UserDTO createUser(UserDTO user);
}
