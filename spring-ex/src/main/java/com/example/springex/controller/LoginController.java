package com.example.springex.controller;


import com.example.springex.loginUser.LoginUser;
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
