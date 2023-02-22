package com.example.flixsterplus

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.flixsterplus2.R

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private  lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var rankCount: TextView
    private lateinit var rankAverage: RatingBar
    private lateinit var posterInfo: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvTitle = findViewById(R.id.tvTitleInfo)
        tvDescription = findViewById(R.id.tvDescriptionInfo)
        tvReleaseDate = findViewById(R.id.tvDateInfo)
        rankCount = findViewById(R.id.tvRanking)
        rankAverage = findViewById(R.id.rbRankAverage)
        posterInfo = findViewById(R.id.ivPosterInfo)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        tvTitle.text = movie.movieTitle
        tvDescription.text = movie.movieDescription
        tvReleaseDate.text =  "Release Date: " + movie.releaseDate
        rankCount.text = movie.rankCount.toString()
        rankAverage.rating = movie.rankAverage.toFloat()
        val imageUrl = movie.posterImageUrl
        Glide.with(this).load(imageUrl).centerCrop().transforms(RoundedCorners(140)).into(posterInfo)
    }
}