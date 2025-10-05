package com.pcrt.softgraph.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pcrt.softgraph.service.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

public class AuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;
    private final ObjectMapper objectMapper;

    public AuthenticationFilter(AuthenticationService authenticationService, ObjectMapper objectMapper) {
        this.authenticationService = authenticationService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws IOException {
        try {
            Authentication authentication = authenticationService.getAuthentication(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("Authentication failed at: " + request.getRequestURI(), e);
            this.writeResponseContent(request, response);
        }
    }

    private void writeResponseContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        problemDetail.setTitle("Authentication failed");
        problemDetail.setInstance(URI.create(request.getRequestURI()));

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = response.getWriter();
        writer.print(objectMapper.writeValueAsString(problemDetail));
        writer.flush();
        writer.close();
    }

}
