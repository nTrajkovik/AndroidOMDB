package com.example.jana_.lab2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by EKENE on 7/23/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";
    public static final String KEY_YEAR = "year";


    // we define a list from the Movie java class

    private List<Movie> Movies;
    private Context context;

    public MovieAdapter(List<Movie> Movies, Context context) {

        // generate constructors to initialise the List and Context objects

        this.Movies = Movies;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final Movie Movie = Movies.get(position);
        holder.login.setText(Movie.getTitle());
        holder.year.setText(Movie.getYear());

        Picasso.with(context)
                .load(Movie.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie Movie1 = Movies.get(position);
                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, Movie1.getTitle());
                skipIntent.putExtra(KEY_URL, Movie1.getId());
                skipIntent.putExtra(KEY_YEAR, Movie1.getYear());
                skipIntent.putExtra(KEY_IMAGE, Movie1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });

    }

    @Override

    //return the size of the listItems (Movie)

    public int getItemCount() {
        return Movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects

        public TextView login;
        public ImageView avatar_url;
        public TextView html_url, year;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View objects

            login = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.imageView);
            html_url = (TextView) itemView.findViewById(R.id.htmUrl);
            year = (TextView) itemView.findViewById(R.id.year);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

    }
}
