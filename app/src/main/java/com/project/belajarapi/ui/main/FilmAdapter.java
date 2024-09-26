package com.project.belajarapi.ui.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.project.belajarapi.R;
import com.project.belajarapi.data.model.Film;
import com.project.belajarapi.databinding.ItemFilmBinding;
import com.project.belajarapi.ui.detail.DetailFilmActivity;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private final ArrayList<Film> listFilm = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setListFilm(ArrayList<Film> films) {
        listFilm.clear();
        listFilm.addAll(films);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding view = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.bind(listFilm.get(position));
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public FilmViewHolder(ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {
            binding.getRoot().setOnClickListener(v -> {
                if (onItemClickCallback != null) {
                    onItemClickCallback.onItemClicked(film);
                }
            });

            Glide.with(binding.getRoot())
                .load(film.getPoster())
                .error(R.drawable.poster_not_found)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivFilm);
            binding.tvTitle.setText(film.getTitle());
            binding.tvYear.setText(film.getYear());
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Film data);
    }

    public static class DetailActivity {
        public static final String EXTRA_FILM = "extra_film";
    }
}