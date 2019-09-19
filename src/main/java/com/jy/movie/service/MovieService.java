package com.jy.movie.service;


import com.jy.movie.entity.*;
import com.jy.movie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MovieService {


    @Autowired
    UserService userService;

    @Autowired
    MovieNoService movieNoService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieTypeService movieTypeService;

    @Autowired
    ActorService actorService;

    @Autowired
    MovieActorRelationService movieActorRelationService;

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

    public String getMoviePublishCountryByName(String name) {

        Movie movie = movieRepository.findByName(name);
        Long movieNo = movie.getMovieNo();

        return movieNoService.getCountryById(movieNo);
    }

    public void addMoviePro(MovieAddParam movieParam) {


        //在电影编号表中添加数据
        MovieNo movieNo = new MovieNo(movieParam.getPublishDate(), movieParam.getPublishCountry());

        movieNoService.addMovieNo(movieNo);

        //在电影表中添加数据
        Long movieNoForMovie = movieNoService.getMovieNoRecentNo();

        MovieType movieType = movieParam.getMovieType();
        Long typeId = movieType.getId();

        Movie movie = new Movie(movieParam.getName(), typeId, movieNoForMovie);

        addMovie(movie);

        //在电影类型表中检查是否存在该电影类型，不存在就添加新类型
        movieTypeService.checkTypeId(movieType);

        //在电影表和演员表many to many 关系的中间表中添加数据
        Long movieId = movieRepository.getRecentId();
        List<Actor> actorList = movieParam.getActorList();
        List<MovieActorRelation> relationList = new ArrayList<>();
        for (Actor actor : actorList) {
            Long actorId = actor.getActorId();
            MovieActorRelation relation = new MovieActorRelation(movieId, actorId);
            relationList.add(relation);

            //在演员表中检查是否存在该演员，不存在就添加新演员
            actorService.checkActorId(actor);

        }

        movieActorRelationService.saveRelations(relationList);


    }

    public List<MovieForShow> getMovieByType(String movieType) {

      Long typeId =   movieTypeService.getTypeId(movieType);

        return getMovieByType(typeId);
    }

    private List<MovieForShow> getMovieByType(Long typeId) {

      List<Movie> movieList =   movieRepository.findAllByTypeNo(typeId);

      List<MovieForShow> movieForShowList = new ArrayList<>();
      for(Movie movie:movieList){
          movieForShowList.add(createMovieForShow(movie));
      }
        return movieForShowList;

    }

    private MovieForShow createMovieForShow(Movie movie) {


        MovieForShow movieForShow = new MovieForShow();
        movieForShow.setId(movie.getId());
        movieForShow.setName(movie.getName());
        movieForShow.setMovieType(movieTypeService.getTypeById(movie.getTypeNo()));
        movieForShow.setPublishDate(movieNoService.getPublishDateById(movie.getMovieNo()));
        movieForShow.setActors(movieActorRelationService.getActorNameList(movie.getId()));
        return movieForShow;
    }


}
