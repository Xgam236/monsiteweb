package com.monsite.monprojet.config;

import com.monsite.monprojet.service.AdminLogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private final AdminLogService adminLogService;

    public CustomLogoutSuccessHandler(AdminLogService adminLogService) {
        this.adminLogService = adminLogService;
    }

    @Override
    public void onLogoutSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        if (authentication != null) {
            adminLogService.log(
                    "LOGOUT",
                    authentication.getName(),
                    "Déconnexion"
            );
        }

        response.sendRedirect("/login?logout");
    }
}