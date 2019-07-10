/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.boot;

import com.infodrive.weather.model.AppStatus;

/**
 * The Class RestResponseUtil.
 */
public class RestResponseUtil {

    /**
     * Gets the default success response.
     *
     * @return the default success response
     */
    public static AppStatus getSuccessStatus() {
        AppStatus status = new AppStatus();
        status.setCode(200);
        status.setDesc("SUCCESS");
        return status;
    }

    /**
     * Gets the error status.
     *
     * @return the error status
     */
    public static AppStatus getErrorStatus() {
        AppStatus status = new AppStatus();
        status.setCode(400);
        status.setDesc("ERROR");
        return status;
    }

    /**
     * Gets the exception status.
     *
     * @return the exception status
     */
    public static AppStatus getExceptionStatus() {
        AppStatus status = new AppStatus();
        status.setCode(500);
        status.setDesc("EXCEPTION");
        return status;
    }
}
