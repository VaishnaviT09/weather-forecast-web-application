package com.weather.forecast.web.application.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static Map<Date, Double> convertStringMapToDateMap(Map<String, Double> stringMap) {
        Map<Date, Double> dateMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2024-07-03 06:00:00

        for (Map.Entry<String, Double> entry : stringMap.entrySet()) {
            String dateString = entry.getKey();
            Double value = entry.getValue();
            try {
                Date date = dateFormat.parse(dateString);
                dateMap.put(date, value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateMap;
    }

    public static Map<Date, Double> sortByDate(Map<Date, Double> unsortedMap) {
        List<Map.Entry<Date, Double>> list = new ArrayList<>(unsortedMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Date, Double>>() {
            @Override
            public int compare(Map.Entry<Date, Double> o1, Map.Entry<Date, Double> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        Map<Date, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Date, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
