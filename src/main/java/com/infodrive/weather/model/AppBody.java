/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import java.io.Serializable;

/**
 * The Class AppBody.
 */
public class AppBody implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The status. */
    private AppStatus status;

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
