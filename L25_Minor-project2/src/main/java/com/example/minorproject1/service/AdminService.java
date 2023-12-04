package com.example.minorproject1.service;

import com.example.minorproject1.dto.CreateAdminRequest;
import com.example.minorproject1.dto.CreateStudentRequest;
import com.example.minorproject1.model.Admin;
import com.example.minorproject1.model.SecuredUser;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Value("${admin.authorities}")
    String authorities;

    @Autowired
    AdminRepository adminRepository;

    public Admin create(CreateAdminRequest createAdminRequest){
        Admin admin = createAdminRequest.to();
        SecuredUser securedUser = admin.getSecuredUser();
        securedUser.setPassword(passwordEncoder.encode(securedUser.getPassword()));
        securedUser.setAuthorities(authorities);

        // create a user
        securedUser = userService.save(securedUser);

        // create a student
        admin.setSecuredUser(securedUser);
        return adminRepository.save(admin);
    }
}
