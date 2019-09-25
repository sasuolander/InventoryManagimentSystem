package main.object.dtoobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.object.entityobject.UserEntity;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class UserDTO implements Serializable {


    private static final long serialVersionUID=1L;
    private long Id;
    private String userId;
    private String username;
    private String password;
    private String encryptedPassword;
    private String role;
    private String email;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus=false;



    /*public UserDTO entityToDTO(UserEntity userEntity){
        this.userId=user;
        this.username;
        this.password;
        this.encryptedPassword;
        this.role;
        this.email;
        this.emailVerificationToken;
        this.emailVerificationStatus;
        return this;

    }*/
}
