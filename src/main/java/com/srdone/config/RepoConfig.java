package com.srdone.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lszakacs on 0008, June 08, 2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.srdone.domain"})
@EnableJpaRepositories(basePackages = {"com.srdone.service"})
@EnableTransactionManagement
public class RepoConfig {
}
