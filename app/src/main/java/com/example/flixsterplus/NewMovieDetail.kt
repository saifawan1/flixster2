package com.example.flixsterplus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.flixsterplus2.R

class NewMovieDetail : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var rankCount: TextView
    private lateinit var rankAverage: RatingBar
    private lateinit var posterInfo: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_detail)
        tvTitle = findViewById(R.id.tvTitleInfoUp)
        tvDescription = findViewById(R.id.tvDescriptionInfoUp)
        tvReleaseDate = findViewById(R.id.tvReleaseDateInfoUp)
        rankCount = findViewById(R.id.tvRankUpInfo)
        rankAverage = findViewById(R.id.rbRankAverageUp)
        posterInfo = findViewById(R.id.ivPosterInfoUp)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_COMING) as UpComingMovie
        tvTitle.text = movie.upMovieTitle
        tvDescription.text = movie.upMovieDescription
        tvReleaseDate.text =  "Release Date: " + movie.upReleaseDate
        rankCount.text = movie.upRankCount.toString()
        rankAverage.rating = movie.upRankAverage.toFloat()
        val imageUrl = movie.posterImageUrlUpcoming
        Glide.with(this).load(imageUrl).centerCrop().transforms(RoundedCorners(140)).into(posterInfo)
    }
}