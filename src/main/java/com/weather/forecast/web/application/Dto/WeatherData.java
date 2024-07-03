package com.weather.forecast.web.application.Dto;

import com.weather.forecast.web.application.service.Util;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WeatherData {
    private final JSONObject data;
    List<Object> list = new ArrayList<>();
    Map<String, Double> result = new HashMap<>();

    public List<Double> getTempData() throws ParseException {

        List<Double> result = new ArrayList<>();
        JSONArray listArray = data.getJSONArray("list");
        Map<String, Double> data = new HashMap<>();
        for (int i = 0; i < listArray.length(); i++) {
            JSONObject item = listArray.getJSONObject(i);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(sdf.format(new Date()));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);

            if (strDate.equals(item.getString("dt_txt").split(" ")[0])) {
                double temp = item.getJSONObject("main").getDouble("temp");
                String dtTxt = item.getString("dt_txt");
                data.put(dtTxt, temp);
            }
        }
        Map<Date, Double> resultData = Util.convertStringMapToDateMap(data);
        Map<Date, Double> resultDataByAscDate = Util.sortByDate(resultData);

        result = resultDataByAscDate.entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return result;
    }

    public WeatherData(JSONObject data) {
        this.data = data;
    }

}
