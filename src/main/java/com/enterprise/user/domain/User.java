package com.example.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User
 * Create user domain model and repository
 */
@Service
public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    public User() {
        logger.info("Initializing User");
    }

    // TODO: Add implementation
}
