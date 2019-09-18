package com.jy.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MovieNo {

    @Id
    @GeneratedValue
    private Long movieNo;

    private String publishDate;

    private String publishCountry;


    public MovieNo() {
    }

    public MovieNo(String publishDate, String publishCountry) {
        this.publishDate = publishDate;
        this.publishCountry = publishCountry;
    }

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
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



}
