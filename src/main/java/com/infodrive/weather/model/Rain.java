/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Rain.
 */
public class Rain {

    /** The h. */
    @JsonProperty(value = "3h")
    public int h;

    /**
     * Gets the h.
     *
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * Sets the h.
     *
     * @param h the new h
     */
    public void setH(int h) {
        this.h = h;
    }

}
