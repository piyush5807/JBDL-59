package com.example.demosecuritydb.configs;

import com.example.demosecuritydb.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DemoUserService demoUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(demoUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic().and().
//                csrf().disable().       // only for testing purpose, should not be used in production env
                authorizeHttpRequests()
//                .antMatchers("/faculty/attendance/**").hasAnyAuthority("check_attendance")
                .antMatchers("/faculty/signup/**").permitAll()
                .antMatchers("/faculty/**").hasAuthority("login_faculty")
                .antMatchers("/student/signup/**").permitAll()
                .antMatchers("/student/**").hasAuthority("login_student")
                .antMatchers("/library/**").hasAnyAuthority("access_library")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    // CSRF - Cross site request forgery

    @Bean
    PasswordEncoder getPE(){ // by default the number of rounds are 10
        return new BCryptPasswordEncoder(); // you need to make sure that the data present with you should be in this format
    }
}
