package com.sinodash.sb.security_form_auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Pass the username to the template
        model.addAttribute("username", authentication.getName());
        
        return "dashboard"; // Points to dashboard.html
    }
}
