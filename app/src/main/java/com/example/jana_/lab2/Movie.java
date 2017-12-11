package com.example.jana_.lab2;

/**
 * Created by EKENE on 7/23/2017.
 */

public class Movie {

    private String title;
    private String avatar_url;
    private String id;
    private String plot, actors;
    private String year;

    public String getTitle() {
        return title;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getId() {
        return id;
    }

    public String getPlot() {
        return plot;
    }
    public String getActors() {
        return actors;
    }


    public void setPlot(String plot) {
        this.plot=plot;
    }
    public void setActors(String actors) {
       this.actors=actors;
    }

    public String getYear() {
        return year;
    }

    public Movie(String title, String id, String year, String avatar_url) {
        this.title = title;
        this.avatar_url = avatar_url;
        this.id = id;
        this.year=year;


    }
}
