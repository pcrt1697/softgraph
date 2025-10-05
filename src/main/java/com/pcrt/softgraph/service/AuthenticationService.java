package com.pcrt.softgraph.service;

import com.pcrt.softgraph.auth.ApiKeyAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    public static final String API_KEY_HEADER_NAME = "x-api-key";

    @Value("${softgraph.api-key}")
    private String apiKey;


    public Authentication getAuthentication(HttpServletRequest request) {
        String providedKey = request.getHeader(API_KEY_HEADER_NAME);
        if (providedKey == null || !providedKey.equals(apiKey)) {
            throw new BadCredentialsException("API key not valid");
        }
        return new ApiKeyAuthentication(providedKey, AuthorityUtils.NO_AUTHORITIES);
    }

}
