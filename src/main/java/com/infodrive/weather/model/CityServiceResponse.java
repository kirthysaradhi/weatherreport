/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Class CityServiceResponse.
 */
public class CityServiceResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The city. */
    private List<String> city;

    /** The status. */
    private AppStatus status;

    /**
     * Gets the city.
     *
     * @return the city
     */
    public List<String> getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(List<String> city) {
        this.city = city;
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
