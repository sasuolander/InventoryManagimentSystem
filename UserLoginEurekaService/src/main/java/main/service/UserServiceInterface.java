package main.service;

import main.object.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

interface UserServiceInterface extends UserDetailsService {
    UserDTO createUser(UserDTO user);
}
