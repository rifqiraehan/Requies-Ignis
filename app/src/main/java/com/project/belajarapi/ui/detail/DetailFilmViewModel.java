package com.project.belajarapi.ui.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.belajarapi.BuildConfig;
import com.project.belajarapi.api.RetrofitClient;
import com.project.belajarapi.data.model.DetailFilmResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFilmViewModel extends ViewModel {
    private MutableLiveData<DetailFilmResponse> detailFilm = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public MutableLiveData<DetailFilmResponse> getDetailFilm() {
        return detailFilm;
    }
    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setFilmDetail(String imdbID) {
        String apiKey = BuildConfig.API_KEY;
        isLoading.setValue(true);

        Log.d("DetailFilmViewModel", "setFilmDetail called with imdbID: " + imdbID);
        RetrofitClient.getApiService()
                .getFilmDetail(apiKey, imdbID, "full")
                .enqueue(new Callback<DetailFilmResponse>() {
                    @Override
                    public void onResponse(Call<DetailFilmResponse> call, Response<DetailFilmResponse> response) {
                        isLoading.setValue(false);
                        if (response.isSuccessful() && response.body() != null) {
                            detailFilm.postValue(response.body());
                            Log.d("DetailFilmViewModel", "API call successful, detailFilm updated");
                        }else {
                            Log.d("DetailFilmViewModel", "API call unsuccessful, response: " + response);
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailFilmResponse> call, Throwable t) {
                        Log.e("API Call", "Failure: " + t.getMessage());
                        isLoading.setValue(false);
                    }
                });
    }


}
