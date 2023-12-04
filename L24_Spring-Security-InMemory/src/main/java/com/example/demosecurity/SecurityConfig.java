package com.example.demosecurity;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // student
    // faculty

    // public (Not authenticated)

    // Authentication related stuff
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("pankaj")
                .password("$2a$10$397d/EOlkZLQo9N24QDKVuyRJGuPc69ljf4CgB5emT.q6yxAyV0Ia")
                .authorities("student")
                .and()
                .withUser("ram")
                .password("$2a$10$QkEP3LzgqLwDV4f0wAVQUerpANy/Fc0KAqUUl51SrJIookfqD5Xly")
                .authorities("faculty");
    }

    // ram123 --> $2a$12$q/46iYhuEWiR.0a/V/5ere2h5RUSeE/83XCthrm6VMoBpprYrSoZq (12 rounds)
    // ram123 --> $2a$12$PIxKX1d/60ZXQbB3SsDduuDu1ssfV0jv.f5dHj0cz/lMWOZudf.jS (12 rounds)

    // encoders never do an exact match, they just check whether two encrypted pwds are similar or not

    // Authorization related stuff
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/faculty/attendance/**").hasAnyAuthority("admin")
                .antMatchers("/faculty/**").hasAuthority("faculty")
                .antMatchers("/student/**").hasAuthority("student")
                .antMatchers("/library/**").hasAnyAuthority("student", "faculty")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

        // most restricted --> least restricted
    }

    @Bean
    PasswordEncoder getPE(){ // by default the number of rounds are 10
        return new BCryptPasswordEncoder(); // you need to make sure that the data present with you should be in this format
    }

    // In order to match the password, spring security needs a password encoder
}
