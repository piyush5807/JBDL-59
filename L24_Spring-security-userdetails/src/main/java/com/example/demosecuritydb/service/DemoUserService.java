package com.example.demosecuritydb.service;

import com.example.demosecuritydb.models.DemoUser;
import com.example.demosecuritydb.repository.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DemoUserService implements UserDetailsService {

    @Autowired
    DemoUserRepository demoUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return demoUserRepository.findByUsername(username);
    }

    public DemoUser save(DemoUser demoUser){
        return this.demoUserRepository.save(demoUser);
    }
}
