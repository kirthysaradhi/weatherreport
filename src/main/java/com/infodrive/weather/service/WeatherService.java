package com.infodrive.weather.service;

import com.infodrive.weather.model.CityServiceResponse;
import com.infodrive.weather.model.WeatherServiceResponse;

public interface WeatherService {

	public WeatherServiceResponse retrieveWeatherByCity(String city);

	public CityServiceResponse retrieveCities();
}
