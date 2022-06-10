package com.codepath.apps.restclienttemplate.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;

    // Pass in context and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // Inflate the layout for each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data at position
        Tweet tweet = tweets.get(position);

        // Bind the data to the view holder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Define a ViewHolder to connect UI with Backend
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvName;
        TextView tvScreenName;
        ImageView ivMedia;
        TextView tvTimeStamp;

        // For tweet interactions
        TextView tvRetweetCount;
        TextView tvFavoriteCount;
        ImageView ivRetweet;
        ImageView ivFavorite;

        // Put all Views in a ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvName = itemView.findViewById(R.id.tvName);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            ivMedia = itemView.findViewById(R.id.ivMedia);
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);

//            TextView tvRetweetCount = itemView.findViewById(R.id.tvRetweetCount);
//            TextView tvFavoriteCount = itemView.findViewById(R.id.tvRetweetCount);
//            ImageView ivRetweet = itemView.findViewById(R.id.ivRetweet);
//            ImageView ivFavorite = itemView.findViewById(R.id.ivFavorite);
        }

        // Set the data for each of the views in the UI
        public void bind(Tweet tweet) {

            tvBody.setText(tweet.body);
            tvName.setText(tweet.user.name);
            tvScreenName.setText(tweet.user.screenName);
            tvTimeStamp.setText(tweet.getRelativeTimeAgo());
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);

            // Embed images into UI by loading media_url and toggling visibility
            if (tweet.mediaUrl != null) {
                ivMedia.setVisibility(View.VISIBLE);
                Glide.with(context).load(tweet.mediaUrl).into(ivMedia);
            } else {
                ivMedia.setVisibility(View.GONE);
            }

//            // Check tweet interactions and set labels and image sources accordingly
//            tvRetweetCount.setText(tweet.retweetCount);
//            tvFavoriteCount.setText(tweet.favoriteCount);
//
//            int retweetImg;
//            int favoriteImg;
//
//            retweetImg = tweet.retweeted ?
//                    R.drawable.ic_vector_retweet :
//                    R.drawable.ic_vector_retweet_stroke;
//            ivRetweet.setImageResource(retweetImg);
//
//            favoriteImg = tweet.retweeted ?
//                    R.drawable.ic_vector_heart :
//                    R.drawable.ic_vector_heart_stroke;
//            ivFavorite.setImageResource(favoriteImg);
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }
}
