package com.jy.movie.entity;

import java.util.List;

public class MovieAddParam {


    private String name;

    private MovieType movieType;    //many to one

    private String publishDate;

    private String publishCountry;

    private List<Actor> actorList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishCountry() {
        return publishCountry;
    }

    public void setPublishCountry(String publishCountry) {
        this.publishCountry = publishCountry;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
