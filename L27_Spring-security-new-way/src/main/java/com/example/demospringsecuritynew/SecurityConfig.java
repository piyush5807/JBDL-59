package com.example.demospringsecuritynew;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    old way of writing authentication related stuff
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("sheikh")
                .password("sheik123")
                .authorities("STUDENT")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("dhanraj")
                .password("dhanraj123")
                .authorities("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/admin").hasAuthority("ADMIN")
                        .antMatchers("/student").hasAuthority("STUDENT")
                        .antMatchers("/").permitAll()
                )
                .httpBasic(Customizer.withDefaults()).formLogin();
        return http.build();
    }

    @Bean
    PasswordEncoder getPE(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
