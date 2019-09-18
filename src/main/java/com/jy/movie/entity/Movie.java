package com.jy.movie.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    Long id;

    private String name;

    private Long typeNo;    //many to one
    private Long movieNo;   //one to one
   // private List<Actor> actors; //many to many

   // private Actor actors;

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, Long typeNo, Long movieNo) {
        this.name = name;
        this.typeNo = typeNo;
        this.movieNo = movieNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Long typeNo) {
        this.typeNo = typeNo;
    }

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

   /* public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }*/
}
