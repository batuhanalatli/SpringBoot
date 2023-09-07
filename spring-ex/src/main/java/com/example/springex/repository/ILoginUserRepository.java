package com.example.springex.repository;

import com.example.springex.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserRepository extends JpaRepository<LoginUser,Integer> {
    LoginUser findByUserName(String userName);

}
