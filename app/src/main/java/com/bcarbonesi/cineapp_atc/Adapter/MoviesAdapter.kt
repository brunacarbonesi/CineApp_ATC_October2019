package com.bcarbonesi.cineapp_atc.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bcarbonesi.cineapp_atc.Data.Movie
import com.bcarbonesi.cineapp_atc.R
import com.bcarbonesi.cineapp_atc.R.mipmap.ic_cine_app_vertical_cinza_foreground
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.squareup.picasso.Picasso

class MoviesAdapter (

    private var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item_theme, parent, false)
            return MovieViewHolder(view)
        }

        override fun getItemCount(): Int = movies.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            holder.bind(movies.get(position))
        }

        fun updateMovies(movies: List<Movie>) {
            this.movies = movies
            notifyDataSetChanged()
        }

        inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val poster: ImageView = itemView.findViewById(R.id.imageViewItemMoviePoster)

            fun bind(movie: Movie) {
                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                    .into(poster)
            }
        }
    }
