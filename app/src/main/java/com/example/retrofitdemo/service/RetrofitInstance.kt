package com.example.retrofitdemo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_URL = "https://api.themoviedb.org/3/"
    private var retrofit: Retrofit? = null

    fun getService(): MovieDataService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(MovieDataService::class.java)
    }
}