/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class BootWebConfig.
 */
@Configuration
public class BootWebConfig {

    /**
     * Filter registration bean.
     *
     * @return the filter registration bean
     */
    @Bean("weatherFilter")
    @ConfigurationProperties(prefix = "filter.weather")
    public FilterRegistrationBean<WeatherFilter> filterRegistrationBean() {
        FilterRegistrationBean<WeatherFilter> bean = new FilterRegistrationBean<>(new WeatherFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }

}
