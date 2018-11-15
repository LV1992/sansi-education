package com.sansi.education.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class SansiEducationWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SansiEducationWebApplication.class, args);
        log.info("SansiEducationWeb start success");
    }
}
