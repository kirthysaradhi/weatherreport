/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infodrive.weather.boot.RestResponseUtil;
import com.infodrive.weather.constants.PropertyConstants;
import com.infodrive.weather.model.CityServiceResponse;
import com.infodrive.weather.model.WeatherServiceRequest;
import com.infodrive.weather.model.WeatherServiceResponse;
import com.infodrive.weather.service.WeatherService;

/**
 * The Class WeatherController.
 */
@Controller
@RequestMapping(PropertyConstants.API_GET)
public class WeatherController {

    /** The weather service. */
    @Autowired
    WeatherService weatherService;

    /**
     * Load app data.
     *
     * @param request the request
     * @return the default json response
     */
    @RequestMapping(value = PropertyConstants.WEATHER, method = RequestMethod.POST)
    @ResponseBody
    public WeatherServiceResponse fetchWeather(@RequestBody WeatherServiceRequest request) {

        WeatherServiceResponse response = new WeatherServiceResponse();

        try {
            response = weatherService.retrieveWeatherByCity(request.getCity());
            response.setStatus(RestResponseUtil.getSuccessStatus());
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(RestResponseUtil.getExceptionStatus());
        }
        return response;

    }

    /**
     * Fetch cities.
     *
     * @return the city service response
     */
    @RequestMapping(value = PropertyConstants.CITIES, method = RequestMethod.GET)
    @ResponseBody
    public CityServiceResponse fetchCities() {

        CityServiceResponse response = new CityServiceResponse();
        try {
            response = weatherService.retrieveCities();
            response.setStatus(RestResponseUtil.getSuccessStatus());
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(RestResponseUtil.getExceptionStatus());
        }
        return response;

    }

    /**
     * Gets the pages.
     *
     * @return the pages
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getPages() {

        ObjectMapper mapper = new ObjectMapper();

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List E");

        ModelAndView model = new ModelAndView("weather");

        String json = "";
        try {
            json = mapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addObject("list", json);

        return model;

    }

}
