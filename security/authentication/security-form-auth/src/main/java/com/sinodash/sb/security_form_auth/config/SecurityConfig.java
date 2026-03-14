package com.sinodash.sb.security_form_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.sinodash.sb.security_form_auth.security.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/login", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                // Specifies the custom login page URL
                .loginPage("/login")
                // URL where the login form is submitted (Spring Security handles this by default)
                .loginProcessingUrl("/login")
                // The default success landing page URL
                .defaultSuccessUrl("/dashboard", true)
                // The failure landing page URL with an error parameter
                .failureUrl("/login?error=true")
                .permitAll()
            ).logout(logout -> logout
                .logoutUrl("/logout")
                // .logoutSuccessUrl("/login?logout=true") // Commented out to use custom handler instead
                .logoutSuccessHandler(new CustomLogoutSuccessHandler()) // Register handler
                .invalidateHttpSession(true)    // Explicitly invalidate session on logout
                .deleteCookies("JSESSIONID")  // Explicitly delete session cookie on logout
                .permitAll() // Ensure everyone can access the logout route
            );
        // Spring Security enables CSRF protection by default
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
            .username("john")
            .password(passwordEncoder().encode("your-passw0rd"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
