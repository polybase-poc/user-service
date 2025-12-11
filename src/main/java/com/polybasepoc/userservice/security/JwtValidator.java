package com.example.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JwtValidator
 * Protected endpoints with JWT validation
 */
@Service
public class JwtValidator {
    private static final Logger logger = LoggerFactory.getLogger(JwtValidator.class);

    public JwtValidator() {
        logger.info("Initializing JwtValidator");
    }

    // TODO: Add implementation
}
