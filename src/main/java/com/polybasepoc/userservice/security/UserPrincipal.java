package com.example.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserPrincipal
 * Protected endpoints with JWT validation
 */
@Service
public class UserPrincipal {
    private static final Logger logger = LoggerFactory.getLogger(UserPrincipal.class);

    public UserPrincipal() {
        logger.info("Initializing UserPrincipal");
    }

    // TODO: Add implementation
}
