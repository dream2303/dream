package com.example.dream.weather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {
    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;
//数组用的list
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
