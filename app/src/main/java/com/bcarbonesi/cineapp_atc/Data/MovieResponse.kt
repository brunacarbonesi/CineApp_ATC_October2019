package com.bcarbonesi.cineapp_atc.Data

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class MovieResponse {

    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("overview")
    var overview: String? = null
}

class Movies {
    @SerializedName("results")
    var results: List<MovieResponse>? = null
    @SerializedName("count")
    var count: String? = null
}
