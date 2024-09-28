package com.project.belajarapi.api;

import com.project.belajarapi.data.model.DetailFilmResponse;
import com.project.belajarapi.data.model.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/")
    Call<FilmResponse> getFilmUsers(@Query("apikey") String apikey, @Query("s") String s);

    @GET("/")
    Call<DetailFilmResponse> getFilmDetail(@Query("apikey") String apikey, @Query("i") String i, @Query("plot") String plot);
}