package com.example.movietraining.fragment;

import com.example.movietraining.BaseFragment;
import com.example.movietraining.adapter.MovieAdpater;
import com.example.movietraining.model.ApiResponseMovie;
import com.example.movietraining.network.ConnectService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePopularFragment extends BaseFragment {
    private ArrayList<ApiResponseMovie.Movie> listMovie = new ArrayList<>();
    private MovieAdpater movieAdpater;
    @Override
    public void callApiMoive() {
        ConnectService.getApiService().getListMoviePopular().enqueue(new Callback<ApiResponseMovie>() {
            @Override
            public void onResponse(Call<ApiResponseMovie> call, Response<ApiResponseMovie> response) {
                if(response.isSuccessful()){
                    ApiResponseMovie apiResponseMovie = response.body();
                    listMovie.addAll(apiResponseMovie.getResults());
                    movieAdpater.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseMovie> call, Throwable t) {

            }
        });
    }
}
