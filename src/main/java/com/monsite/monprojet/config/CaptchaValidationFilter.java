package com.monsite.monprojet.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CaptchaValidationFilter extends OncePerRequestFilter {

    public static final String CAPTCHA_SESSION_KEY = "LOGIN_CAPTCHA_RESULT";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        boolean isLoginPost =
                request.getMethod().equalsIgnoreCase("POST")
                        && request.getServletPath().equals("/login");

        if (!isLoginPost) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);

        String expectedCaptcha = null;

        if (session != null) {
            Object captchaValue = session.getAttribute(CAPTCHA_SESSION_KEY);

            if (captchaValue != null) {
                expectedCaptcha = captchaValue.toString();
            }
        }

        String userCaptcha = request.getParameter("captchaAnswer");

        if (expectedCaptcha == null
                || userCaptcha == null
                || !expectedCaptcha.trim().equals(userCaptcha.trim())) {

            response.sendRedirect(request.getContextPath() + "/login?captchaError=true");
            return;
        }

        session.removeAttribute(CAPTCHA_SESSION_KEY);

        filterChain.doFilter(request, response);
    }
}