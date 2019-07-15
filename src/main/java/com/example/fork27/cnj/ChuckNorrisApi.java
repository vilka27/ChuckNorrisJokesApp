package com.example.fork27.cnj;

import com.example.fork27.cnj.models.Joke;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ChuckNorrisApi {

    @GET("/jokes/random")
    Call<Joke> getData();

    @GET("/jokes/random")
    Single<Joke> getJokeSingle();


}





