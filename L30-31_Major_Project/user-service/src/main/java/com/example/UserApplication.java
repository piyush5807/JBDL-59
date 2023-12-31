package com.example;

import com.example.models.User;
import com.example.repositories.UserRepository;
import com.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(
                User.builder()
                        .name("Txn-service")
                        .mobile("txnservice")
                        .authorities(Constants.SERVICE_AUTHORITY)
                        .password(new BCryptPasswordEncoder().encode("P@ass123"))
                        .build()
        );
    }
}