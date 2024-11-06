package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long>{
    List<UserData> findByEmail(String email);
    List<UserData> findByUsername(String username);
}
