package com.example.services;

import com.example.configs.SecurityConfig;
import com.example.dtos.UserCreateRequest;
import com.example.repositories.UserCacheRepository;
import com.example.repositories.UserRepository;
import com.example.models.User;
import com.example.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCacheRepository userCacheRepository;

    @Autowired
    ObjectMapper objectMapper;


    public void create(UserCreateRequest userCreateRequest) throws JsonProcessingException {
        User user = userCreateRequest.to();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); //TODO: Remove from here and make only one single point of contact for pe related changes

        userRepository.save(user);

        // Communicate to wallet-service to create a user's wallet
        // Ex: Wallet creation takes ~ 3-5 seconds, you don't want your users to wait till that time
        // asynchronously via kafka

        JSONObject event = objectMapper.convertValue(user, JSONObject.class);
        String msg = objectMapper.writeValueAsString(event);
        kafkaTemplate.send(Constants.USER_CREATED_TOPIC, msg);

    }

    public User get(int userId) {
        User user = this.userCacheRepository.get(userId);
        if(user == null){
            user = this.userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
            this.userCacheRepository.save(user);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByMobile(username);
    }
}
