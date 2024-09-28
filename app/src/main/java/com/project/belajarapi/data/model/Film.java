package com.project.belajarapi.data.model;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Poster")
    private String poster;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Response")
    private String Response;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }
    public String getImdbID() {
        return imdbID;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return Response;
    }

}