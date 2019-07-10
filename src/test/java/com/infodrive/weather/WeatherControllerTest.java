/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.infodrive.weather.boot.Boot;

/**
 * The Class WeatherControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Boot.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WeatherControllerTest {

    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;

    /** The city weather request. */
    private String cityWeatherRequest;

    /** The http headers. */
    private HttpHeaders httpHeaders;

    /**
     * Inits the.
     */
    @Before
    public void init() {
        try {
            httpHeaders = new HttpHeaders();
            httpHeaders.add("Origin", "*");
            httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");
            cityWeatherRequest = IOUtils.toString(this.getClass().getResourceAsStream("/json/cityWeatherRequest.json"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the cities test.
     *
     * @return the cities test
     * @throws Exception the exception
     */
    @Test
    public void getCitiesTest() throws Exception {
        try {
            mockMvc.perform(get("/api/get/cities").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.log());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    /**
     * Gets the weather by city test.
     *
     * @return the weather by city test
     * @throws Exception the exception
     */
    @Test
    public void getWeatherByCityTest() throws Exception {
        try {
            mockMvc.perform(post("/api/get/weather").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON_UTF8).content(cityWeatherRequest))
                    .andExpect(status().isOk()).andDo(MockMvcResultHandlers.log());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
