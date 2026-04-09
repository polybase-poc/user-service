package com.example.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserRepository
 * Create user domain model and repository
 */
@Service
public class UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository() {
        logger.info("Initializing UserRepository");
    }

    // TODO: Add implementation
}
