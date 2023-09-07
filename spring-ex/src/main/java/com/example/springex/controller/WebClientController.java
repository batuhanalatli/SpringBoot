package com.example.springex.controller;

import com.example.springex.entity.ApiUser;
import com.example.springex.pojo.ApiUserPojo;
import com.example.springex.service.WebClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/web")
public class WebClientController {

    WebClientService webClientService;

    @GetMapping("/get")
    public Flux<ResponseEntity<ApiUserPojo>> getData(){
        return webClientService.getData().map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllAndSave")
    public List<ApiUser> getAndSave(){
        return webClientService.getAllnSaveToDB();
    }
}