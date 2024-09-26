package com.project.belajarapi.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.project.belajarapi.R;
import com.project.belajarapi.data.model.Film;
import com.project.belajarapi.databinding.ActivityMainBinding;
import com.project.belajarapi.ui.detail.DetailFilmActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        adapter = new FilmAdapter();
        adapter.notifyDataSetChanged();

        adapter.setOnItemClickCallback(new FilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film data) {
                Intent intent = new Intent(MainActivity.this, DetailFilmActivity.class);
                intent.putExtra(DetailFilmActivity.EXTRA_FILM, data.getImdbID());
                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        binding.rvFilm.setLayoutManager(new LinearLayoutManager(this));
        binding.rvFilm.setHasFixedSize(true);
        binding.rvFilm.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.rvFilm.addItemDecoration(dividerItemDecoration);

        binding.btnSearch.setOnClickListener(v -> searchFilm());

        binding.etQuery.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchFilm();
                    return true;
                }
                return false;
            }
        });

        viewModel.getListFilm().observe(this, it -> {
            if(it != null && !it.isEmpty()) {
                adapter.setListFilm(it);
                binding.tvNoMovies.setVisibility(View.GONE);
                binding.tvStartMessage.setVisibility(View.GONE);
            }
        });

        viewModel.getIsLoading().observe(this, isLoading -> {
            showLoading(isLoading);
            if (isLoading) {
                binding.tvNoMovies.setVisibility(View.GONE);
            } else if (viewModel.getListFilm().getValue() == null) {
                binding.tvNoMovies.setVisibility(View.GONE);
            } else if (viewModel.getListFilm().getValue().isEmpty()) {
                binding.tvNoMovies.setVisibility(View.VISIBLE);
            } else {
                binding.tvNoMovies.setVisibility(View.GONE);
            }
        });
    }

    private void searchFilm() {
        String query = binding.etQuery.getText().toString().trim();
        if (query.isEmpty()) return;

        adapter.setListFilm(new ArrayList<>());

        viewModel.setSearchMovies(query);
        binding.tvStartMessage.setVisibility(View.GONE);
    }

    private void showLoading(Boolean state) {
        if (state) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }
}