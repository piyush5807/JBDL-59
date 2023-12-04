package com.example.minorproject1.configs;

import com.example.minorproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .csrf()
                .disable() // only for testing purpose, should not be used in production env
                .authorizeHttpRequests()
                .antMatchers("/student/details/**").hasAuthority("get-student-profile")
                .antMatchers(HttpMethod.GET, "/student/**").hasAuthority("get-student-details")
                .antMatchers(HttpMethod.POST, "/student/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/admin/**").permitAll() // wrong
                .antMatchers("/student/**").hasAuthority("update-student-account") // PUT DELETE PATCH methods if any
                .antMatchers(HttpMethod.GET, "/book/**").hasAuthority("get-book-details")
                .antMatchers("/book/**").hasAuthority("update-book")
                .antMatchers("/transaction/**").hasAuthority("book-transaction")
                .antMatchers(HttpMethod.POST, "/admin/**").hasAuthority("add-admin")
                .and()
                .formLogin();
    }

    // CSRF - Cross site request forgery

    @Bean
    PasswordEncoder getPE(){ // by default the number of rounds are 10
        return new BCryptPasswordEncoder(); // you need to make sure that the data present with you should be in this format
    }
}
