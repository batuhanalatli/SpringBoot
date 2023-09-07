package com.example.springex.service;

import com.example.springex.repository.ILoginUserRepository;
import com.example.springex.entity.LoginUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
