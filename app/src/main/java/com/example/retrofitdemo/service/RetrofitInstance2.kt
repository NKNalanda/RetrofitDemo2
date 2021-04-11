package com.example.retrofitdemo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    private val BASE_URL = "https://api.themoviedb.org/3/"
    private var retrofit: Retrofit? = null

    fun getService(): MovieDataService2 {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(MovieDataService2::class.java)
    }
}