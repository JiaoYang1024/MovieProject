package com.jy.movie.controller;

import com.jy.movie.entity.Movie;
import com.jy.movie.entity.MovieAddParam;
import com.jy.movie.entity.MovieForShow;
import com.jy.movie.entity.MovieType;
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


    @GetMapping("/getMoviePublishCountryByName")
    public String getMoviePublishCountryByName(@RequestBody Movie movie){

        String name = movie.getName();

       return movieService.getMoviePublishCountryByName(name);


    }

    @PostMapping("/addMovie")
    public String addMoviePro(@RequestBody MovieAddParam movieParam) {
        //movieService.addMovie(movie.getName());
        movieService.addMoviePro(movieParam);
//        movieList.add(movie.getName());
        return "success";
    }

    @GetMapping("/getMoviesByType")
    public List<MovieForShow> getMoviesByType(@RequestBody MovieType movieType){

        return movieService.getMovieByType(movieType.getTypeName());
    }
}
