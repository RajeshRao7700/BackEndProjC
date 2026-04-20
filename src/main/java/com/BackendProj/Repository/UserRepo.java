package com.BackendProj.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendProj.Entity.User;

public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
    
    
}
