package com.sinodash.sb.security_form_auth.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Authentication authentication) 
                                throws IOException, ServletException {
        
        if (authentication != null && authentication.getPrincipal() != null) {
            String username = authentication.getName();
            // Perform Audit Logging here
            System.out.println("Audit Log: User " + username + " has logged out.");
        }

        // After logic, redirect the user
        response.sendRedirect("/login?logout=true");
    }
}
