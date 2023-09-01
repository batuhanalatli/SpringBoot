package com.example.springex.loginUser;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserRepository extends JpaRepository<LoginUser,Integer> {
    LoginUser findByUserName(String userName);

}
