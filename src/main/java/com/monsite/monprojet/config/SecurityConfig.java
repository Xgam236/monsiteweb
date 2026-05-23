package com.monsite.monprojet.config;

import com.monsite.monprojet.service.CustomUserDetailsService;
import com.monsite.monprojet.service.LoginAttemptService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final LoginAttemptService loginAttemptService;
    private final CustomAuthenticationFailureHandler failureHandler;
    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomLogoutSuccessHandler logoutSuccessHandler;

    public SecurityConfig(
            CustomUserDetailsService customUserDetailsService,
            LoginAttemptService loginAttemptService,
            CustomAuthenticationFailureHandler failureHandler,
            CustomAuthenticationSuccessHandler successHandler,
            CustomLogoutSuccessHandler logoutSuccessHandler
    ) {
        this.customUserDetailsService = customUserDetailsService;
        this.loginAttemptService = loginAttemptService;
        this.failureHandler = failureHandler;
        this.successHandler = successHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CaptchaValidationFilter captchaValidationFilter() {
        return new CaptchaValidationFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService) {

            @Override
            protected void additionalAuthenticationChecks(
                    UserDetails userDetails,
                    org.springframework.security.authentication.UsernamePasswordAuthenticationToken authentication
            ) {

                if (loginAttemptService.isBlocked(userDetails.getUsername())) {
                    throw new LockedException("Trop de tentatives. Compte temporairement bloqué.");
                }

                super.additionalAuthenticationChecks(userDetails, authentication);
            }
        };

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authenticationProvider(authenticationProvider())

                .addFilterBefore(
                        captchaValidationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                )

                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/login",
                                "/register",
                                "/verify",

                                "/style.css",
                                "/home.css",
                                "/fiche.css",
                                "/planning.css",
                                "/adminpage.css",

                                "/images/**",
                                "/js/**"
                        ).permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(successHandler)
                        .failureHandler(failureHandler)
                        .permitAll()
                )

                .rememberMe(remember -> remember
                        .key("revision-school-secret-key-2026")
                        .rememberMeParameter("remember-me")
                        .tokenValiditySeconds(7 * 24 * 60 * 60)
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                )

                .sessionManagement(session -> session
                        .sessionFixation(sessionFixation -> sessionFixation.migrateSession())
                );

        return http.build();
    }
}