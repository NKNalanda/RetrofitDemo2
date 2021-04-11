package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitdemo.model.MovieDBResponse
import com.example.retrofitdemo.service.MovieDataService
import com.example.retrofitdemo.service.MovieDataService2
import com.example.retrofitdemo.service.RetrofitInstance
import com.example.retrofitdemo.service.RetrofitInstance2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var movieDataService: MovieDataService = RetrofitInstance.getService()
        var popularMovies: Call<MovieDBResponse> = movieDataService.getPopularMovies(
            this.getString(R.string.api_key)
        )

        popularMovies.enqueue(object : Callback<MovieDBResponse> {
            override fun onResponse(
                call: Call<MovieDBResponse>,
                response: Response<MovieDBResponse>
            ) {
                val movieDBResponse: MovieDBResponse? = response.body()
                Log.i(TAG, movieDBResponse?.totalMovies.toString())
            }

            override fun onFailure(call: Call<MovieDBResponse>, t: Throwable) {
                Log.e(TAG, t.toString())
            }

        })

        var latestMovies: Call<MovieDBResponse> = movieDataService.getLatestMovies(
            this.getString(R.string.api_key)
        )

        latestMovies.enqueue(object: Callback<MovieDBResponse> {
            override fun onResponse(call: Call<MovieDBResponse>, response: Response<MovieDBResponse>) {
                val movieDBResponse: MovieDBResponse? = response.body()
                Log.e(TAG, movieDBResponse?.totalMovies.toString())
            }

            override fun onFailure(call: Call<MovieDBResponse>, t: Throwable) {
                Log.e(TAG, t.toString())
            }

        })

        var movieDataService2: MovieDataService2 = RetrofitInstance2.getService()
        var upcomingMovies: Call<MovieDBResponse> = movieDataService2.getUpcomingMovies(
            this.getString(R.string.api_key)
        )
        upcomingMovies.enqueue(object : Callback<MovieDBResponse> {
            override fun onResponse(
                call: Call<MovieDBResponse>,
                response: Response<MovieDBResponse>
            ) {
                val movieDBResponse: MovieDBResponse? = response.body()
                Log.e(TAG, movieDBResponse?.totalMovies.toString())
            }

            override fun onFailure(call: Call<MovieDBResponse>, t: Throwable) {
                Log.e(TAG, t.toString())
            }

        })
    }

    companion object {
        private const val TAG = "RetrofitDemo"
    }
}