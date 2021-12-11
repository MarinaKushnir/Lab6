package com.company;

import java.util.Comparator;
/*https://holidays.abstractapi.com/v1/?api_key=c6905d1f2b964a9e9a5812514bce40a2&country=US&year=2020&month=11&day=01*/

//name_local language description не реализованы так как они пусты

public class Holiday {
    private String name;
    private String country;
    private String location;
    private String type;
    private String date;
    private String weekDay;

    public String getName() {
        return name;
    }
    public void getName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void getCountry(String country) {
        this.country = country;
    }
    public String getLocation() {
        return location;
    }
    public void getLocation(String location) {
        this.location = location;
    }
    public String getType() {
        return type;
    }
    public void getType(String type) {
        this.type = type;
    }
    public String getDate() {
        return date;
    }
    public void getDate(String date) {
        this.date = date;
    }
    public String getWeekDay() {
        return weekDay;
    }
    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Holiday(String name,  String country, String location, String type, String date,  String weekDay) {
        super();
        this.name = name;
        this.country = country;
        this.location = location;
        this.type = type;
        this.date = date;
        this.weekDay = weekDay;
    }

    @Override
    public String toString()
    {
        return "Holiday name = " + name +
                ",country = " + country +
                ",location = " + location +
                ",type = " + type +
                ",date = " + date ;
    }
    public static Comparator<Holiday> byNameAsc = Comparator.comparing(o -> o.name);
    public static Comparator<Holiday> byNameDesc = (o1, o2) -> o2.name.compareTo(o1.name);
}
