package com.example.movietraining.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectService {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static ApiServiceMovie getApiService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiServiceMovie.class);
    }
}
