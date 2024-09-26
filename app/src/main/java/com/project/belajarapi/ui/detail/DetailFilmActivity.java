package com.project.belajarapi.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.project.belajarapi.R;
import com.project.belajarapi.databinding.ActivityDetailFilmBinding;

public class DetailFilmActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";

    private ActivityDetailFilmBinding binding;
    private DetailFilmViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailFilmBinding.inflate(getLayoutInflater());

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(binding.getRoot());

        String imdbID = getIntent().getStringExtra(EXTRA_FILM);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailFilmViewModel.class);

        viewModel.setFilmDetail(imdbID);

        viewModel.getDetailFilm().observe(this, it -> {
            if(it != null) {
                Log.d("DetailFilmActivity", "detailFilm updated: " + it);

                binding.tvTitle.setText(it.getTitle());
                binding.tvYear.setText(it.getYear());
                binding.tvPlot.setText(it.getPlot());
                if (it.getPoster() != null) {
                    Glide.with(this)
                            .load(it.getPoster())
                            .error(R.drawable.poster_not_found)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .centerCrop()
                            .into(binding.ivPoster);
                } else {
                    Log.d("DetailFilmActivity", "Poster URL is null");
                }
            } else {
                Log.d("DetailFilmActivity", "detailFilm is null");
            }
        });

        viewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressBarDetail.setVisibility(View.VISIBLE);
            } else {
                binding.progressBarDetail.setVisibility(View.GONE);
            }
        });
    }
}