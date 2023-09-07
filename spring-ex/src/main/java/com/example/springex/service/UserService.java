package com.example.springex.service;

import com.example.springex.repository.ILoginUserRepository;
import com.example.springex.entity.LoginUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    ILoginUserRepository loginUserRepository;

    public record newUserRequest (int id, String userName, String password){}

    //save
    public String  registerUser(LoginUser loginUser) {
        loginUserRepository.save(loginUser);
        return "User Saved!";
    }

    //delete

    public String deleteUser(int id){
        loginUserRepository.deleteById(id);
        return "User Deleted!";
    }

    //update

    public String updateUser(int id,newUserRequest userRequest){

        LoginUser loginUser = new LoginUser();
        loginUser.setId(id);
        loginUser.setUserName(userRequest.userName);
        loginUser.setPassword(userRequest.password);
        loginUserRepository.save(loginUser);
        return "User Updated";
    }
}
