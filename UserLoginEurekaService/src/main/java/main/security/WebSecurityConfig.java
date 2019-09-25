package main.security;

import main.service.UserServiceIml;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceIml userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(UserServiceIml userDetailsService,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.userDetailsService=userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/h2/**").permitAll()
                .and().authorizeRequests()
                .antMatchers("/h2/login.do/**").permitAll()
                .and().authorizeRequests()
                .antMatchers("/h2/query.do/**").permitAll()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/users").permitAll()
                .anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()));
    }
}
