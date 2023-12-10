package com.example.minorproject1.repository;

import com.example.minorproject1.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
}
