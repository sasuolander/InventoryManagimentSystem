package main.controller;

import main.object.dtoobject.UserDTO;
import main.object.requestobject.UserRequest;
import main.object.responseobject.UserResponse;
import main.service.UserServiceIml;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserController(UserServiceIml userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserResponse returnValue = new UserResponse();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userRequest, userDTO);
        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @GetMapping
    public String getUser() {
        return "";
    }

    @GetMapping
    public String getUsers() {
        return "";
    }

    public String updateUser() {
        return "";
    }
}
