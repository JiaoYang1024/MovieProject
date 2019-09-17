package com.jy.movie.controller;

import com.jy.movie.entity.Movie;
import com.jy.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    private List<String> movieList = new ArrayList<>(Arrays.asList("泰坦尼克号", "电锯惊魂", "笑傲江湖"));

    @GetMapping
    public List<Movie> getMovies() {

        return movieService.getMovieList();

        //return movieList;
    }

    @GetMapping("/find")
    public Movie getMovieById(@RequestParam int id) {

        return movieService.getMovieById(id);

        //  return movieList.get(id);
    }

    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie) {
        //movieService.addMovie(movie.getName());
        movieService.addMovie(movie);
//        movieList.add(movie.getName());
        return "success";
    }

    @PutMapping("/update")
    public String updateMovie(@RequestParam int id, @RequestBody Movie movie) {
      //  movieList.set(id, movie.getName());
        movieService.updateMovie(id,movie);
        return "success";
    }


    @DeleteMapping("/delete")
    public String deleteMovie(@RequestParam int id) {
        movieService.deleteMovieById(id);
        //movieList.remove(id);
        return "success";
    }


}
