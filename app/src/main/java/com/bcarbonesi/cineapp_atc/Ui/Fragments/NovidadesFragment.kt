package com.bcarbonesi.cineapp_atc.Ui.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bcarbonesi.cineapp_atc.Data.Movie
import com.bcarbonesi.cineapp_atc.Data.MoviesRepository
import com.bcarbonesi.cineapp_atc.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_novidades.*

/**
 * A simple [Fragment] subclass.
 */
class NovidadesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MoviesRepository.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.fragment_novidades, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewTeste.text = "funcionando"
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        Log.d("MainActivity", "Movies: $movies")
    }

    private fun onError() {
        Snackbar.make(view!!.rootView, "Please check your internet connection", Snackbar.LENGTH_SHORT).show()
    }
}