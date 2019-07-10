/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infodrive.weather.constants.PropertyUtil;
import com.infodrive.weather.model.CityServiceResponse;
import com.infodrive.weather.model.WeatherEntity;
import com.infodrive.weather.model.WeatherServiceResponse;

/**
 * The Class WeatherServiceImpl.
 */
@Service
public class WeatherServiceImpl extends PropertyUtil implements WeatherService {

    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see com.infodrive.weather.service.WeatherService#retrieveWeatherByCity(java.lang.String)
     */
    @Override
    public WeatherServiceResponse retrieveWeatherByCity(String city) {
        String openWeatherUrl = getOpenWeatherApi() + city;
        System.out.println("URL:" + openWeatherUrl);

        WeatherEntity response = restTemplate.getForObject(openWeatherUrl, WeatherEntity.class);

        ResponseEntity<WeatherEntity> responseEntity = restTemplate.getForEntity(openWeatherUrl, WeatherEntity.class);
        System.out.println("Response :" + response);
        System.out.println("ResponseEntity :" + responseEntity.getBody());
        return constructWeatherResponse(responseEntity.getBody());
    }

    /**
     * Construct weather response.
     *
     * @param body the body
     * @return the weather service response
     */
    private WeatherServiceResponse constructWeatherResponse(WeatherEntity body) {
        WeatherServiceResponse resp = new WeatherServiceResponse();

        resp.setCity(body.getName());
        resp.setTemperature(String.valueOf(body.getMain().getTemp()));
        resp.setUpdatedtime("");
        resp.setWeather(String.valueOf(body.getMain().getTemp()));

        resp.setWind(String.valueOf(body.getWind().getSpeed()));
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.infodrive.weather.service.WeatherService#retrieveCities()
     */
    @Override
    public CityServiceResponse retrieveCities() {

        CityServiceResponse response = new CityServiceResponse();
        response.setCity(Arrays.asList(getCityList().split(",")));
        return response;
    }

}
