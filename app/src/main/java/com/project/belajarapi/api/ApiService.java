package com.project.belajarapi.api;

import com.project.belajarapi.data.model.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/")
    Call<FilmResponse> getFilmUsers(@Query("apikey") String apikey, @Query("s") String s);
}