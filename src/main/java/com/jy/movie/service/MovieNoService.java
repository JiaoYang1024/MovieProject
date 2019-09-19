package com.jy.movie.service;

import com.jy.movie.entity.MovieNo;
import com.jy.movie.repository.MovieNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class MovieNoService {


    @Autowired
    MovieNoRepository movieNoRepository;


    public void addMovieNo(MovieNo movieNo){

        movieNoRepository.save(movieNo);


    }


    public Long getMovieNoRecentNo(){
        return movieNoRepository.getRecentId();
    }

    public String getCountryById(Long movieNo) {
        Optional<MovieNo> movieNoOptional = movieNoRepository.findById(movieNo);

        String publishCountry = "未知";

        if (movieNoOptional.isPresent()) {

            publishCountry = movieNoOptional.get().getPublishCountry();
        }
        return publishCountry;
    }


    public String getPublishDateById(Long movieNo) {

        Optional<MovieNo> movieNoOptional = movieNoRepository.findById(movieNo);

        String publishDate = "未知";

        if (movieNoOptional.isPresent()) {

            publishDate = movieNoOptional.get().getPublishCountry();
        }
        return publishDate;
    }
}
