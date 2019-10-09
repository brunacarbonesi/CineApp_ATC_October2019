package com.bcarbonesi.cineapp_atc.Ui.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bcarbonesi.cineapp_atc.Data.MoviesRepository
import com.bcarbonesi.cineapp_atc.R
import kotlinx.android.synthetic.main.fragment_novidades.*

/**
 * A simple [Fragment] subclass.
 */
class NovidadesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MoviesRepository.getPopularMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.fragment_novidades, container, false)

    }
}