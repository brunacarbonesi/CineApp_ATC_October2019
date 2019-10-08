package com.bcarbonesi.cineapp_atc.Data

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Movie (

    val id: Int,
    val vote_average: String,
    val title: String,
    val overview: String,
    val adult: Boolean
)
