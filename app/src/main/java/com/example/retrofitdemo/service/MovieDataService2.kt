package com.example.retrofitdemo.service

import com.example.retrofitdemo.model.MovieDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService2 {

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String): Call<MovieDBResponse>
}