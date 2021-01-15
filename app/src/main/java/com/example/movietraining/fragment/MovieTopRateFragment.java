package com.example.movietraining.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movietraining.BaseFragment;
import com.example.movietraining.adapter.MovieAdpater;

import com.example.movietraining.model.ApiResponseMovie;
import com.example.movietraining.network.ConnectService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieTopRateFragment extends BaseFragment {
    private MovieAdpater movieAdpater;
    private ArrayList<ApiResponseMovie.Movie> listMovie = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void callApiMoive() {
        ConnectService.getApiService().getListMovieTopRate().enqueue(new Callback<ApiResponseMovie>() {
            @Override
            public void onResponse(Call<ApiResponseMovie> call, Response<ApiResponseMovie> response) {
                ApiResponseMovie apiResponseMovie = response.body();
                listMovie.addAll(apiResponseMovie.getResults());
                movieAdpater.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ApiResponseMovie> call, Throwable t) {

            }
        });
    }

}
