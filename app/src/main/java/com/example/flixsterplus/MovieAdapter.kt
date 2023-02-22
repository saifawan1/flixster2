package com.example.flixsterplus

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.flixsterplus2.R

const val MOVIE_EXTRA = "MOVIE_EXTRA"
const val MOVIE_COMING = "MOVIE_EXTRA_UPCOMING"
class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val tvReleaseDate = itemView.findViewById<TextView>(R.id.tvReleaseDate)

        fun bind(movie: Movie) {
            tvTitle.text = movie.movieTitle
            tvDescription.text = movie.movieDescription
            tvDescription.movementMethod = ScrollingMovementMethod()
            tvReleaseDate.text = movie.releaseDate
            Glide.with(context).load(movie.posterImageUrl).placeholder(R.drawable.ic_launcher_background).centerCrop().transforms(
                RoundedCorners(120)).error(R.drawable.ic_launcher_foreground).listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            }).into(ivPoster)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val movie = movies[adapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_movie, viewGroup, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
}

class UpcomingAdapter(private val mContext: Context, private val newMovies:MutableList<UpComingMovie>) :
    RecyclerView.Adapter<UpcomingAdapter.MViewHolder>(){
    inner class MViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val tvTitleUp = itemView.findViewById<TextView>(R.id.tvNewMovieTitle)
        private val tvDescriptionUp = itemView.findViewById<TextView>(R.id.tvDescriptionUp)
        private val ivPosterUp = itemView.findViewById<ImageView>(R.id.ivNewPoster)
        private val tvReleaseDateUp = itemView.findViewById<TextView>(R.id.tvNewReleaseDate)

        fun bind(upComingMovie: UpComingMovie) {
            tvTitleUp.text = upComingMovie.upMovieTitle
            tvDescriptionUp.text = upComingMovie.upMovieDescription
            tvReleaseDateUp.text = upComingMovie.upReleaseDate
            Glide.with(mContext).load(upComingMovie.posterImageUrlUpcoming).placeholder(R.drawable.ic_launcher_background).centerCrop().transforms(
                RoundedCorners(120)).error(R.drawable.ic_launcher_foreground).listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            }).into(ivPosterUp)
        }


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val movie = newMovies[adapterPosition]
            val intent = Intent(mContext,NewMovieDetail::class.java)
            intent.putExtra(MOVIE_COMING, movie)
            mContext.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_new_movie, viewGroup,false)
        return MViewHolder(view)

    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val movie = newMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return newMovies.size
    }

}