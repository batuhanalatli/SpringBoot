package com.example.springex.controller;

import com.example.springex.entity.LoginUser;
import com.example.springex.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@SpringBootApplication
@RequestMapping("/user")
public class UserController {

    UserService userService;


    @PostMapping("/save")
    public String registerUser(@RequestBody LoginUser loginUser){return userService.registerUser(loginUser);}

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){return userService.deleteUser(id);}

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody UserService.newUserRequest userRequest){return userService.updateUser(id, userRequest);}
}
