package com.jy.movie.service;

import com.jy.movie.entity.MovieType;
import com.jy.movie.repository.MovieTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class MovieTypeService {


    @Autowired
    MovieTypeRepository movieTypeRepository;


    public void checkTypeId(MovieType movieType) {

      Optional<MovieType> movieTypeOptional =  movieTypeRepository.findById(movieType.getId());

      if (!movieTypeOptional.isPresent()){

          movieTypeRepository.save(movieType);

      }

    }

    public Long getTypeId(String movieType) {



        MovieType type = movieTypeRepository.findByTypeName(movieType);

        return type.getId();
    }
}
