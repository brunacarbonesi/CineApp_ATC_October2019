package com.bcarbonesi.cineapp_atc.Data

import retrofit2.Call;
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "28462c086aa50bfdb7f5d824170f5df7",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "28462c086aa50bfdb7f5d824170f5df7",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}