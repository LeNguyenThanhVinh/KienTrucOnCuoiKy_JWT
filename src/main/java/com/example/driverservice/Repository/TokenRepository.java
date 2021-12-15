package com.example.driverservice.Repository;

import com.example.driverservice.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {

}
