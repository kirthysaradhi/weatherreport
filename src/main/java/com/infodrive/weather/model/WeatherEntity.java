/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
package com.infodrive.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Class WeatherEntity.
 */
public class WeatherEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The coord. */
    public Coorinates coord;

    /** The weather. */
    public List<Weather> weather;

    /** The base. */
    public String base;

    /** The main. */
    public Main main;

    /** The visibility. */
    public int visibility;

    /** The wind. */
    public Wind wind;

    /** The rain. */
    public Rain rain;

    /** The name. */
    public String name;

    /**
     * Gets the coord.
     *
     * @return the coord
     */
    public Coorinates getCoord() {
        return coord;
    }

    /**
     * Sets the coord.
     *
     * @param coord the new coord
     */
    public void setCoord(Coorinates coord) {
        this.coord = coord;
    }

    /**
     * Gets the weather.
     *
     * @return the weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * Sets the weather.
     *
     * @param weather the new weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * Gets the base.
     *
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets the base.
     *
     * @param base the new base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Gets the main.
     *
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * Sets the main.
     *
     * @param main the new main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Gets the visibility.
     *
     * @return the visibility
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility.
     *
     * @param visibility the new visibility
     */
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the wind.
     *
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Sets the wind.
     *
     * @param wind the new wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * Gets the rain.
     *
     * @return the rain
     */
    public Rain getRain() {
        return rain;
    }

    /**
     * Sets the rain.
     *
     * @param rain the new rain
     */
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WeatherEntity [coord=" + coord + ", weather=" + weather + ", base=" + base + ", main=" + main + ", visibility=" + visibility
                + ", wind=" + wind + ", rain=" + rain + ", name=" + name + "]";
    }

}
