package com.bcarbonesi.cineapp_atc.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getCurrentMovieData(@Query("APPID") app_id: String): Call<Movies>
}

//fun getCurrentMovieData(@Path("id") id: Int, @Query("APPID") app_id: String): Call<MovieResponse>