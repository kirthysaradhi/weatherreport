/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.boot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;

/**
 * The Class WeatherFilter.
 */
public class WeatherFilter implements Filter {

    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(WeatherFilter.class);

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            addResponseHeaders(req, res);
            logger.trace("Before Chaining");
            chain.doFilter(request, response);
            logger.trace("After Chaining");
        } finally {
            logger.trace("Before clearing store: {}", ((HttpServletRequest) request).getRequestURI());
            ThreadStore.clear();
            MDC.clear();
        }
    }

    /**
     * Adds the response headers.
     *
     * @param req the req
     * @param res the res
     */
    private void addResponseHeaders(HttpServletRequest req, HttpServletResponse res) {
        res.addHeader("X-UA-Compatible", "IE=edge");
        res.addHeader("X-XSS-Protection", "1; mode=block;");
        res.addHeader("X-Content-Type-Options", "nosniff");
        res.addHeader("X-FRAME-OPTIONS", "DENY");
        // res.addHeader("Content-Security-Policy", PropertyUtils.getProperty(SystemConstants.HEADER_CSP));
        // res.addHeader("Access-Control-Expose-Headers", SystemConstants.X_FILENAME);
        res.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, max-age=0, must-revalidate"); // HTTP 1.1.
        res.addHeader(HttpHeaders.PRAGMA, "no-cache");
        res.setDateHeader(HttpHeaders.EXPIRES, 0); // Proxies.
        res.setHeader("Access-Control-Allow-Headers", "Authorization");
        res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        res.setHeader("Access-Control-Allow-Headers",
                "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.debug("WeatherFilter Mode");
    }
}
