package com.example.springex.repository;

import com.example.springex.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<ApiUser, Integer> {
}
