package main.object.entityobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {


    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private long userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String encruptedPassword;
    private String role;
    @Column(unique = true)
    private String email;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus=false;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncruptedPassword() {
        return encruptedPassword;
    }

    public void setEncruptedPassword(String encruptedPassword) {
        this.encruptedPassword = encruptedPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
