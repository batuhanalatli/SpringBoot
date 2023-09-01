package com.example.springex.interceptor;

import com.example.springex.exceptions.KeyCacheException;
import com.example.springex.loginUser.ILoginUserRepository;
import com.example.springex.loginUser.LoginUser;
import com.example.springex.service.KeyCacheService;
import com.example.springex.service.LoginService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpFilter;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Authenticator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//@Order(1)
@AllArgsConstructor
@Component
public class SecurityFilter extends HttpFilter {

    private static final String TEST_URL = "/test/login";
    private KeyCacheService keyCacheService;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request.getRequestURI().equals(TEST_URL)) {
            chain.doFilter(request, response);

        } else {
            try {
                String key = request.getHeader("Authorization");
                keyCacheService.checkKey(key);
                chain.doFilter(request, response);

            } catch (KeyCacheException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }

}
