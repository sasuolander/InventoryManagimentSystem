package main.service;


import main.Utils;
import main.object.dtoobject.UserDTO;
import main.object.entityobject.UserEntity;
import main.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();


        if (userRepository.findByEmail(userDTO.getEmail())!=null)throw new RuntimeException("Record already exist");
        BeanUtils.copyProperties(userDTO, userEntity);
        //NULL not allowed for column "ENCRYPTED_PASSWORD";
        String publicUserId=utils.generateUserId(30);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.setUserId(publicUserId);

        UserEntity storedUser = userRepository.save(userEntity);

        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(storedUser, returnValue);
        //ModelMapper modelMapper = new ModelMapper();
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
