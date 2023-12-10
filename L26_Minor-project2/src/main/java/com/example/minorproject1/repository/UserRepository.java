package com.example.minorproject1.repository;

import com.example.minorproject1.model.SecuredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SecuredUser, Integer> {

    SecuredUser findByUsername(String user);
}
