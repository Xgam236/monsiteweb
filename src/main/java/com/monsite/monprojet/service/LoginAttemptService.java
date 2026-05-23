package com.monsite.monprojet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS = 5;
    private static final int LOCK_MINUTES = 10;

    private final Map<String, Integer> attempts = new ConcurrentHashMap<>();
    private final Map<String, LocalDateTime> lockedUntil = new ConcurrentHashMap<>();

    public void loginFailed(String username) {
        int newAttempts = attempts.getOrDefault(username, 0) + 1;
        attempts.put(username, newAttempts);

        if (newAttempts >= MAX_ATTEMPTS) {
            lockedUntil.put(username, LocalDateTime.now().plusMinutes(LOCK_MINUTES));
        }
    }

    public void loginSucceeded(String username) {
        attempts.remove(username);
        lockedUntil.remove(username);
    }

    public boolean isBlocked(String username) {
        LocalDateTime lockTime = lockedUntil.get(username);

        if (lockTime == null) {
            return false;
        }

        if (LocalDateTime.now().isAfter(lockTime)) {
            lockedUntil.remove(username);
            attempts.remove(username);
            return false;
        }

        return true;
    }
}