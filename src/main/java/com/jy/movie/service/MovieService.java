package com.jy.movie.service;


import com.jy.movie.entity.Movie;
import com.jy.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MovieService {


    @Autowired
    UserService userService;

    @Autowired
    MovieRepository movieRepository;


    public void addMovie(String name) {
        movieRepository.save(new Movie(name));
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }


    public List<Movie> getMovieList() {

        return movieRepository.findAll();

    }

    public Movie getMovieById(long id) {

        Optional<Movie> moviePackage = movieRepository.findById(id);
        Movie movie = new Movie();
        if (moviePackage.isPresent()) {
            movie = moviePackage.get();
        }
        return movie;
    }

    public void updateMovie(long id, Movie movie) {
        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }
}
