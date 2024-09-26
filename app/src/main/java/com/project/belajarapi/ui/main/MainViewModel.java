package com.project.belajarapi.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.belajarapi.BuildConfig;
import com.project.belajarapi.api.RetrofitClient;
import com.project.belajarapi.api.ApiService;
import com.project.belajarapi.data.model.Film;
import com.project.belajarapi.data.model.FilmResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainViewModel extends ViewModel{

    private MutableLiveData<ArrayList<Film>> listFilm = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public MutableLiveData<ArrayList<Film>> getListFilm() {
        return listFilm;
    }
    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }


    public void setSearchMovies(String query) {
        String apiKey = BuildConfig.API_KEY;
        listFilm.setValue(new ArrayList<>());
        isLoading.setValue(true);
        RetrofitClient.getApiService()
            .getFilmUsers(apiKey, query)
            .enqueue(new Callback<FilmResponse>() {
                @Override
                public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                    isLoading.setValue(false);
                    if (response.isSuccessful() && response.body() != null && response.body().getSearch() != null) {
                        listFilm.postValue(response.body().getSearch());
                    }
                }

                @Override
                public void onFailure(Call<FilmResponse> call, Throwable t) {
                    Log.e("API Call", "Failure: " + t.getMessage());
                    isLoading.setValue(false);
                }
        });
    }
}