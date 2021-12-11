package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Search {
    public ArrayList<Holiday> getSearch() {
        return search;
    }

    public Search(ArrayList<Holiday> search) {
        this.search = search;
    }

    public void setSearch(ArrayList<Holiday> search) {
        this.search = search;
    }

    private ArrayList<Holiday> search;

    public Search() {
        search = new ArrayList<>();
    }

    public void add(Holiday holiday) {
        this.search.add(holiday);
    }

    @Override
    public String toString() {
        String result = "Search holiday (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (Holiday c : search) {
            result += c + System.lineSeparator();
        }
        return result;
    }

    public Search filterByCountry(String country) {
        Search tempRats = new Search();
        for (Holiday holiday : this.search) {
            if (holiday.getCountry().toLowerCase().contains(country.toLowerCase())) {
                tempRats.add(holiday);
            }
        }
        return tempRats;
    }
    public Search filterByType(String type) {
        Search tempRats = new Search();
        for (Holiday holiday : this.search) {
            if (holiday.getCountry().toLowerCase().contains(type.toLowerCase())) {
                tempRats.add(holiday);
            }
        }
        return tempRats;
    }
}
