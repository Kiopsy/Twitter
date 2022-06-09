package com.codepath.apps.restclienttemplate.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codepath.apps.restclienttemplate.R;

public class TweetDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
    }
}


//public class MovieDetailsActivity extends AppCompatActivity {
//
//    Context context;
//
//    // the movie to display
//    Movie movie;
//
//    // the view objects
//    TextView tvTitle;
//    TextView tvOverview;
//    ImageView tvPoster;
//    RatingBar rbVoteAverage;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_movie_details);
//        // resolve the view objects
//        tvTitle = (TextView) findViewById(R.id.tvTitle);
//        tvOverview = (TextView) findViewById(R.id.tvOverview);
//        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
//        tvPoster = (ImageView) findViewById(R.id.tvPoster);
//
//        // unwrap the movie passed in via intent, using its simple name as a key
//        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
//        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));
//
//        // set the title, overview, and poster (w/ placeholder)
//        tvTitle.setText(movie.getTitle());
//        tvOverview.setText(movie.getOverview());
//        String imageUrl = movie.getPosterPath();
//        int placeholder = R.drawable.flicks_movie_placeholder;
//
//        // load image & placeholder
//        Glide.with(this).load(imageUrl).placeholder(placeholder).into(tvPoster);
//
//        // vote average is 0..10, convert to 0..5 by dividing by 2
//        float voteAverage = movie.getVoteAverage().floatValue();
//        rbVoteAverage.setRating(voteAverage / 2.0f);
//    }
//}