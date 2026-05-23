package com.monsite.monprojet.service;

import com.monsite.monprojet.entity.AdminLog;
import com.monsite.monprojet.repository.AdminLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogService {

    private final AdminLogRepository repository;

    public AdminLogService(AdminLogRepository repository) {
        this.repository = repository;
    }

    public void log(String action, String username, String details) {
        repository.save(new AdminLog(action, username, details));
    }

    public List<AdminLog> getLastLogs() {
        return repository.findTop100ByOrderByCreatedAtDesc();
    }
}