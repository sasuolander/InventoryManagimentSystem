package main.security;

import main.object.requestobject.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // hard coding the userRequests. All passwords must be encoded.
        final List<UserRequest> userRequests = Arrays.asList(
                new UserRequest(1L, "omar", encoder.encode("12345"), "USER"),
                new UserRequest(2L, "admin", encoder.encode("12345"), "ADMIN")
        );


        for(UserRequest userRequest : userRequests) {
            if(userRequest.getUsername().equals(username)) {

                // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
                // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + userRequest.getRole());

                // The "UserRequest" class is provided by Spring and represents a model class for userRequest to be returned by UserDetailsService
                // And used by auth manager to verify and check userRequest authentication.
                return new org.springframework.security.core.userdetails.User(userRequest.getUsername(), userRequest.getPassword(), grantedAuthorities);
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

}
