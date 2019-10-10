package com.bcarbonesi.cineapp_atc.Data

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class GetMoviesResponse (

    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)



