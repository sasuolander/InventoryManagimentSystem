package main.object.requestobject;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UserRequest {

    private long id;
    private String username;
    private String password;
    private String role;
    private String email;

    public UserRequest(long id, String username, String password, String role, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRequest)) return false;
        UserRequest userRequest = (UserRequest) o;
        return Objects.equals(getId(), userRequest.getId()) &&
                Objects.equals(getUsername(), userRequest.getUsername()) &&
                Objects.equals(getPassword(), userRequest.getPassword()) &&
                Objects.equals(getRole(), userRequest.getRole()) &&
                Objects.equals(getEmail(), userRequest.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getRole(), getEmail());
    }
}
