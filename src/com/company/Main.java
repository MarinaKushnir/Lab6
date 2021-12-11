package com.company;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args)
    {
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://holidays.abstractapi.com/v1/?api_key=c6905d1f2b964a9e9a5812514bce40a2&country=US&year=2020&month=11&day=01";
        jsonGetter.run();

        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        // Считываем json
        Object obj = null;
        try
        {
            obj = new JSONParser().parse(jsonString);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray.toJSONString());
        System.out.println();

        Search search = new Search();

        for (Object jsonObject : jsonArray)
        {
            JSONObject hd = (JSONObject) jsonObject;

            String name = (String) hd.get("name");
            String country = (String) hd.get("country");
            String location = (String) hd.get("location");
            String type = (String) hd.get("type");
            String date = (String) hd.get("date");
            String weekDay = (String) hd.get("weekDay");
            Holiday holiday = new Holiday(name, country, location, type, date, weekDay);
            search.add(holiday);
        }


        search.getSearch().sort(Holiday.byNameAsc);
        System.out.println("After sorting by name ascending:\n" + search);
        search.getSearch().sort(Holiday.byNameDesc);
        System.out.println("After sorting by name descending:\n" + search);

        Search withUS = search.filterByCountry("US");
        System.out.println("Filtered holidays with 'US' in country:" + withUS);

        Search withChristian = search.filterByType("Cristian");
        System.out.println("Filtered holidays with 'Cristian' in type:" + withChristian);
    }
}



