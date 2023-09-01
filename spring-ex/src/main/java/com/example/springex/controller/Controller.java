package com.example.springex.controller;


import com.example.springex.loginUser.ILoginUserRepository;
import com.example.springex.loginUser.LoginUser;
import com.example.springex.service.LoginService;
import com.example.springex.service.ServiceTest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@SpringBootApplication
@RequestMapping("/test")
public class Controller {
    private ServiceTest serviceTest;
    LoginService loginService;


//    @GetMapping("/print")
//    public List<LoginUser> getLoginUsers(){
//        return loginUserRepository.findAll();
//    }


//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody LoginUser loginUser){
//        loginUserRepository.save(loginUser);
//        return ResponseEntity.ok("User Registered!");
//    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUser loginUser){
        return loginService.login(loginUser);
    }

    @GetMapping("/log")
    public String log(){
        return serviceTest.log();
    }

}
