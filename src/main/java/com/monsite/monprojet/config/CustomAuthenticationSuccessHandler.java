package com.monsite.monprojet.config;

import com.monsite.monprojet.service.AdminLogService;
import com.monsite.monprojet.service.LoginAttemptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final LoginAttemptService loginAttemptService;
    private final AdminLogService adminLogService;

    public CustomAuthenticationSuccessHandler(
            LoginAttemptService loginAttemptService,
            AdminLogService adminLogService
    ) {
        this.loginAttemptService = loginAttemptService;
        this.adminLogService = adminLogService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        loginAttemptService.loginSucceeded(authentication.getName());

        adminLogService.log(
                "LOGIN",
                authentication.getName(),
                "Connexion réussie"
        );

        response.sendRedirect("/home");
    }
}