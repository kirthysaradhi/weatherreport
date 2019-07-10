/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import java.io.Serializable;

/**
 * The Class DefaultJsonResponse.
 */
public class DefaultJsonResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The hdr. */
    private AppHeader hdr;

    /**
     * Gets the hdr.
     *
     * @return the hdr
     */
    public AppHeader getHdr() {
        return hdr;
    }

    /**
     * Sets the hdr.
     *
     * @param hdr the new hdr
     */
    public void setHdr(AppHeader hdr) {
        this.hdr = hdr;
    }
}
