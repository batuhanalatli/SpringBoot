package com.example.springex.interceptor;

import com.example.springex.exceptions.KeyCacheException;
import com.example.springex.service.KeyCacheService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpFilter;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(1)
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
