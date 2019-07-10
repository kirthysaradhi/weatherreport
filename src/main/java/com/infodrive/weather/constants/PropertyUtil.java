/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.constants;

import org.springframework.beans.factory.annotation.Value;

/**
 * The Class PropertyUtil.
 */
public abstract class PropertyUtil {

    /** The open weather api. */
    @Value("${open.weather.api}")
    private String openWeatherApi;

    /** The city list. */
    @Value("${open.city.list}")
    private String cityList;

    /**
     * Gets the open weather api.
     *
     * @return the open weather api
     */
    public String getOpenWeatherApi() {
        return openWeatherApi;
    }

    /**
     * Gets the city list.
     *
     * @return the city list
     */
    public String getCityList() {
        return cityList;
    }

}
