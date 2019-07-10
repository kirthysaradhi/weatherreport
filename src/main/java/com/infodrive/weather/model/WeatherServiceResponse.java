/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import java.io.Serializable;

/**
 * The Class WeatherServiceResponse.
 */
public class WeatherServiceResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The city. */
    private String city;

    /** The updatedtime. */
    private String updatedtime;

    /** The weather. */
    private String weather;

    /** The temperature. */
    private String temperature;

    /** The wind. */
    private String wind;

    /** The status. */
    private AppStatus status;

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the updatedtime.
     *
     * @return the updatedtime
     */
    public String getUpdatedtime() {
        return updatedtime;
    }

    /**
     * Sets the updatedtime.
     *
     * @param updatedtime the new updatedtime
     */
    public void setUpdatedtime(String updatedtime) {
        this.updatedtime = updatedtime;
    }

    /**
     * Gets the weather.
     *
     * @return the weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     * Sets the weather.
     *
     * @param weather the new weather
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * Gets the temperature.
     *
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature.
     *
     * @param temperature the new temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the wind.
     *
     * @return the wind
     */
    public String getWind() {
        return wind;
    }

    /**
     * Sets the wind.
     *
     * @param wind the new wind
     */
    public void setWind(String wind) {
        this.wind = wind;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public AppStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(AppStatus status) {
        this.status = status;
    }

}
