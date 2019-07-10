/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * The Class Boot.
 */
@SpringBootApplication
public class Boot {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }

    /**
     * Rest template.
     *
     * @param builder the builder
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * The Class SpringBoot.
     */
    @SpringBootApplication
    @ComponentScan(basePackages = { "com.infodrive.weather" })
    class SpringBoot extends SpringBootServletInitializer {

        /*
         * (non-Javadoc)
         * 
         * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
         */
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(SpringBoot.class);
        }
    }

}
