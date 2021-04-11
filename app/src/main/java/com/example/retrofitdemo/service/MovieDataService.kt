package com.example.retrofitdemo.service

import com.example.retrofitdemo.model.MovieDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieDBResponse>

    @GET("movie/popular")
    fun getLatestMovies(@Query("api_key") apiKey: String): Call<MovieDBResponse>
}