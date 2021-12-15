package com.example.driverservice.Repository;

import com.example.driverservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
