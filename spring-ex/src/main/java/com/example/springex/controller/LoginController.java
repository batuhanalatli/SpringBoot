package com.example.springex.controller;


import com.example.springex.entity.LoginUser;
import com.example.springex.service.LoginService;
import com.example.springex.service.ServiceTest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@SpringBootApplication
@RequestMapping("/test")
public class LoginController {
    private ServiceTest serviceTest;
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginUser loginUser){
        return loginService.login(loginUser);
    }

    @GetMapping("/log")
    public String log(){
        return serviceTest.log();
    }
}