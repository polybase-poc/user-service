package com.example.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseEntity
 * Create user domain model and repository
 */
@Service
public class BaseEntity {
    private static final Logger logger = LoggerFactory.getLogger(BaseEntity.class);

    public BaseEntity() {
        logger.info("Initializing BaseEntity");
    }

    // TODO: Add implementation
}
