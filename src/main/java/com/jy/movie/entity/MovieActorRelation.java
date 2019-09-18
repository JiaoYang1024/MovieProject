package com.jy.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MovieActorRelation {

    @Id
    @GeneratedValue
    private Long id;


    private Long movieId;

    private Long actorId;

    public MovieActorRelation() {
    }

    public MovieActorRelation(Long movieId, Long actorId) {
        this.movieId = movieId;
        this.actorId = actorId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "MovieActorRelation{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", actorId=" + actorId +
                '}';
    }
}








