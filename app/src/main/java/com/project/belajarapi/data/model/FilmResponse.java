package com.project.belajarapi.data.model;

import java.util.ArrayList;

public class FilmResponse {
    private ArrayList<Film> Search;

    public ArrayList<Film> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<Film> Search) {
        this.Search = Search;
    }
    private ArrayList<Film> results;

    public ArrayList<Film> getResults() {
        return results;
    }

    public void setResults(ArrayList<Film> results) {
        this.results = results;
    }

}
