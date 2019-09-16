package main.service;

import main.object.dtoobject.UserDTO;

interface UserServiceInterface {
    UserDTO createUser(UserDTO user);
}
