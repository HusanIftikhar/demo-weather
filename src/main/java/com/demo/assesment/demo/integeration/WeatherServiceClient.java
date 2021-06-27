package com.demo.assesment.demo.integeration;

public interface WeatherServiceClient {
    /**
     * This method is use to call the external api to retrieve the current weather info
     * i
     *
     * @param location accept the location information city or city and country code.e {Berlin or Berlin,DE}
     *
     * @return the raw json response in string
     */
    String getCurrentWeatherByLocation(String location);
    /**
     * This method is use to call the external api to retrieve the current weather info
     * @param location accept the location information city or city and country code.e {Berlin or Berlin,DE}
     * @return the raw json response in string
     */
    String getWeatherHistoryByLocation(String location);
}
