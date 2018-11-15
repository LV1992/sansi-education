package com.sansi.education.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class SansiEducationServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SansiEducationServiceUserApplication.class, args);
        log.info("SansiEducationServiceUser start success");
    }
}
