package com.example.movietraining.network;

import com.example.movietraining.model.ApiResponseMovie;
import com.example.movietraining.model.ApiResponseMovieDetail;
import com.example.movietraining.model.ApiResponseMovieVideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceMovie {
    @GET("movie/popular?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovie> getListMoviePopular();

    @GET("movie/now_playing?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovie> getListMovieNowPlaying();

    @GET("movie/upcoming?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovie> getListMovieUpComing();

    @GET("movie/top_rated?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovie> getListMovieTopRate();

    @GET("movie/{movie_id}?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovieDetail> getListMovieDetail(@Path("movie_id") int movie_id);

    @GET("movie/{movie_id}/videos?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponseMovieVideo> getListMovieVideo(@Path("movie_id") int movie_id);


}
