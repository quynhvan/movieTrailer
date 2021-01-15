package com.example.movietraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietraining.R;
import com.example.movietraining.databinding.ItemMovieBinding;
import com.example.movietraining.model.ApiResponseMovie;

import java.util.ArrayList;

public class MovieAdpater extends RecyclerView.Adapter<MovieAdpater.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ApiResponseMovie.Movie> listMovie = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie, parent, false);
        return new MyViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding itemMovieBinding;
        public ObservableField<String> tvTitle = new ObservableField<>();
        public ObservableField<String> tvStarRate = new ObservableField<>();
        public ObservableField<String> ivAnh = new ObservableField<>();

        public MyViewHolder(@NonNull ItemMovieBinding itemView) {
            super(itemView.getRoot());
            this.itemMovieBinding = itemView;
        }

        public void setBinding(ApiResponseMovie.Movie movie, int position) {
            if (itemMovieBinding.getItemMovie() == null) {
                itemMovieBinding.setItemMovie(this);
            }
            tvTitle.set(movie.getTitle());
            tvStarRate.set(Double.toString(movie.getVoteAverage()));

        }

    }
}
