package com.sinodash.sb.security_oauth2.controller;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/user/info")
    public Map<String, Object> userInfo(OAuth2AuthenticationToken authentication) {
        return authentication.getPrincipal().getAttributes();
    }
}
