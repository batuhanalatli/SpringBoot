package com.example.springex.service;

import com.example.springex.entity.ApiUser;
import com.example.springex.pojo.ApiUserPojo;
import com.example.springex.repository.ILoginUserRepository;
import com.example.springex.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@AllArgsConstructor
public class WebClientService {

    @Autowired
    private UserRepo userRepo;
    private WebClient webClient;

    public WebClientService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();
    }


    public Flux<ApiUserPojo> getData() {
        return webClient.get().uri("/users").retrieve().bodyToFlux(ApiUserPojo.class);
    }

    public List<ApiUser> getAllnSaveToDB() {
        List<ApiUserPojo> list = getData().collectList().block();
        List<ApiUser> entityList = list.stream().map(x -> {
            ApiUser tmpEntity = new ApiUser();
            tmpEntity.setId(x.getId());
            tmpEntity.setLogin(x.getLogin());
            tmpEntity.setNode_id(x.getNode_id());
            return tmpEntity;
        }).toList();
        return userRepo.saveAll(entityList);
    }
}