package com.project.belajarapi.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Film {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Search")
    private ArrayList<Film> Search;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Response")
    private String Response;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public ArrayList<Film> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<Film> Search) {
        this.Search = Search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

}