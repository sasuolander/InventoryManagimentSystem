package main.service;


import main.Utils;
import main.object.dtoobject.UserDTO;
import main.object.entityobject.UserEntity;
import main.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserServiceInterface {

    private final UserRepository userRepository;
    private final Utils utils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceIml(UserRepository userRepository,Utils utils,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.utils =utils;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }


    public UserDTO createUser(UserDTO user) {
        UserEntity userEntity = new UserEntity();


        if (userRepository.findByEmail(user.getEmail())!=null)throw new RuntimeException("Record already exist");

        String publicUserId=utils.generateUsetId(30);
        userEntity.setEncruptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(publicUserId);
        BeanUtils.copyProperties(user, userEntity);
        UserEntity storedUser = userRepository.save(userEntity);
        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(storedUser, returnValue);
        return returnValue;
    }
}
