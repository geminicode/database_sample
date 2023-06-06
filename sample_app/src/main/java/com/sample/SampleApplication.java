package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        log.info("************  Starting application!");
        SpringApplication.run(SampleApplication.class, args);
    }
	
}
