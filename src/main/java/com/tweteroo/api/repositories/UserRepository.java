package com.tweteroo.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
