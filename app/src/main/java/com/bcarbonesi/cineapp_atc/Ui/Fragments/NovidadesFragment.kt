package com.bcarbonesi.cineapp_atc.Ui.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bcarbonesi.cineapp_atc.Adapter.MoviesAdapter
import com.bcarbonesi.cineapp_atc.Data.Movie
import com.bcarbonesi.cineapp_atc.Data.MoviesRepository
import com.bcarbonesi.cineapp_atc.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_novidades.*

/**
 * A simple [Fragment] subclass.
 */
class NovidadesFragment : Fragment() {

    private lateinit var popularMoviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //recyclerViewPopularMovies.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)

        popularMoviesAdapter = MoviesAdapter(listOf())
        // recyclerViewPopularMovies.adapter = popularMoviesAdapter

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

        Log.d("onViewCreated", "OnViewCreated!")

    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        Log.d("MainActivity", "Movies: ${movies.get(19).title}")
        popularMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Snackbar.make(view!!.rootView, "Please check your internet connection", Snackbar.LENGTH_SHORT).show()
    }
}