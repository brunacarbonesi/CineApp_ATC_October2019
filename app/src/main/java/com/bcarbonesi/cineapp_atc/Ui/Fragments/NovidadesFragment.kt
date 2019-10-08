package com.bcarbonesi.cineapp_atc.Ui.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bcarbonesi.cineapp_atc.Data.MovieService
import com.bcarbonesi.cineapp_atc.Data.MovieResponse
import com.bcarbonesi.cineapp_atc.Data.Movies
import com.bcarbonesi.cineapp_atc.R
import kotlinx.android.synthetic.main.fragment_novidades.*
import kotlinx.android.synthetic.main.fragment_novidades.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class NovidadesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_novidades, container, false)

        view.buttonTeste.setOnClickListener { view ->
            //textViewTeste.text = "Funcionando"
            getMovieData()
        }

        // Return the fragment view/layout
        return view

    }

    internal fun getMovieData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(MovieService::class.java)
        val call = service.getCurrentMovieData(AppId)
        call.enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.code() == 200) {
                    val movieResponse = response.body()!!

                    val stringBuilder = "Country: " +
                            movieResponse.results?.get(2)?.originalTitle +
                            "\n" +
                            "Vote Average" +
                            movieResponse.results?.get(2)?.overview

                    textViewTeste!!.text = stringBuilder
                    textViewTeste!!.text = "Funcionando"
                }
                textViewTeste!!.text = response.code().toString()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                textViewTeste!!.text = t.message
            }
        })
    }

    companion object {

        var BaseUrl = "https://api.themoviedb.org/3/"
        var AppId = "28462c086aa50bfdb7f5d824170f5df7"
    }

}