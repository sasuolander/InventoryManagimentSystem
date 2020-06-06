package main.controller;

import main.object.dto.UserDTO;
import main.object.request.UserRequest;
import main.object.response.UserResponse;
import main.service.UserServiceIml;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceIml userServiceIml;

    @Autowired
    public UserController(UserServiceIml userServiceIml) {
        this.userServiceIml = userServiceIml;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserResponse returnValue = new UserResponse();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userRequest, userDTO);
        UserDTO createdUser = userServiceIml.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @GetMapping
    public String getUser() {
        return "";
    }

    public String updateUser() {
        return "";
    }
}
