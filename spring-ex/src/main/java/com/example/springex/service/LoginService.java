package com.example.springex.service;

import com.example.springex.loginUser.ILoginUserRepository;
import com.example.springex.loginUser.LoginUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
public class LoginService {

    private ILoginUserRepository loginUserRepository;
    private KeyCacheService keyCacheService;

    public String login(LoginUser loginUser) {

        LoginUser userInRepo = loginUserRepository.findByUserName(loginUser.getUserName());
        if (userInRepo != null && userInRepo.getPassword().equals(loginUser.getPassword())) {
            String tmpKey = "abc123";
            keyCacheService.putKey(tmpKey);
            return tmpKey;
        } else {
            return "Not Auth";
        }
    }

}
