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
    private static String key;
    private static Date date;

    public String login(LoginUser loginUser) {

        LoginUser userInRepo = loginUserRepository.findByUserName(loginUser.getUserName());
        if (userInRepo != null && userInRepo.getPassword().equals(loginUser.getPassword())) {
            String tmpKey = "abc";
            tmpKey = key;
            date = new Date();
            return "Success";
        } else {
            return "Not Auth";
        }
    }

    public boolean isTokenValid(String tmpKey) {
        Date tmpDate = new Date();

        if (key == null || date == null) {
            return false;
        }
        long diffInMillies = Math.abs(tmpDate.getTime() - date.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (diff>60){
            return false;
        }
        return key.equals(tmpKey);
    }

}
