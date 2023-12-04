package com.example.demosecuritydb.repository;

import com.example.demosecuritydb.models.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoUserRepository extends JpaRepository<DemoUser, Integer> {

    DemoUser findByUsername(String user);
}
