package com.example.springex.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceTest {

    public String log() {
        final String transactionId = UUID.randomUUID().toString();
        log.info(transactionId);
        return transactionId;
    }
}
