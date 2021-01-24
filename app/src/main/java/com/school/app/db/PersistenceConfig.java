package com.school.app.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Marker class for configuring SpringBoot JPA capabilities.
 */
@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfig {

}
