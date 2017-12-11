package com.example.jana_.lab2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    public String plot;
    public String director;
    public String genre;
    public String released;
    public String runtime;
    public String actors;
    public String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView profileImageView = (ImageView) findViewById(R.id.profileImageView);

        final TextView Tgenre = (TextView) findViewById(R.id.genre);
        final TextView Trelease = (TextView) findViewById(R.id.Release);
        final TextView Truntime = (TextView) findViewById(R.id.runtime);
        final TextView Tactors = (TextView) findViewById(R.id.actors);
        final TextView Tdirector = (TextView) findViewById(R.id.director);
        final TextView Tplot = (TextView) findViewById(R.id.plot);



        final TextView userNameTextView = (TextView) findViewById(R.id.usernameTextView);


        Intent intent = getIntent();
        final String userName = intent.getStringExtra(MovieAdapter.KEY_NAME);
        String image = intent.getStringExtra(MovieAdapter.KEY_IMAGE);
        final String profileUrl = intent.getStringExtra(MovieAdapter.KEY_URL);
        String url = "http://www.omdbapi.com/?i="+profileUrl+"&plot=full&apikey=26388b2b";

        Picasso.with(this)
                .load(image)
                .into(profileImageView);

      //  userNameTextView.setText(userName);
        String URL_DATA = "http://www.omdbapi.com/?i="+profileUrl+"&plot=full&apikey=26388b2b";
        //developerUrl.setText(profileUrl);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    plot=jsonObject.getString("Plot");
                    actors=jsonObject.getString("Actors");
                    director=jsonObject.getString("Director");
                    genre=jsonObject.getString("Genre");
                    released=jsonObject.getString("Released");
                    runtime=jsonObject.getString("Runtime");
                    title=jsonObject.getString("Title");


                    userNameTextView.setText(title);
                    Tplot.setText(plot);
                    Trelease.setText(released);
                    Tactors.setText(actors);
                    Tdirector.setText(director);
                    Tgenre.setText(genre);
                    Truntime.setText(runtime);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ProfileActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }



    }

