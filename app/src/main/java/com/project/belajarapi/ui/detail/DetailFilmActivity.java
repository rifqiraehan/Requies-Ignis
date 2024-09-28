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
    public static final String EXTRA_TITLE = "extra_title";

    private ActivityDetailFilmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailFilmBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String imdbID = getIntent().getStringExtra(EXTRA_FILM);

        DetailFilmViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailFilmViewModel.class);

        viewModel.setFilmDetail(imdbID);

        viewModel.getDetailFilm().observe(this, it -> {
            if(it != null) {
                Log.d("DetailFilmActivity", "detailFilm updated: " + it);

                binding.tvTitle.setText(it.getTitle());
                binding.tvYear.setText(it.getYear());
                binding.tvPlot.setText(it.getPlot());
                binding.tvRated.setText(it.getRated());
                binding.tvDuration.setText(it.getRuntime());
                binding.tvType.setText(it.getType());
                binding.tvGenre.setText(it.getGenre());
                binding.tvScore.setText(it.getImdbRating());

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
                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }

                binding.progressBarDetail.setVisibility(View.VISIBLE);
                binding.scrollViewContent.setVisibility(View.INVISIBLE);
            } else {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().show();
                    String title = getIntent().getStringExtra(EXTRA_TITLE);
                    getSupportActionBar().setTitle(title);
                }

                binding.progressBarDetail.setVisibility(View.GONE);
                binding.scrollViewContent.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}