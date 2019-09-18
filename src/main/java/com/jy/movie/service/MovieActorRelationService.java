package com.jy.movie.service;

import com.jy.movie.entity.MovieActorRelation;
import com.jy.movie.repository.MovieActorRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MovieActorRelationService {

    @Autowired  //忘记加@Autowired的话，会报错nullpoint
    MovieActorRelationRepository movieActorRelationRepository;


    public void saveRelations(List<MovieActorRelation> relationList) {

        movieActorRelationRepository.saveAll(relationList);
    }

    public void saveRelation(MovieActorRelation relation) {

        movieActorRelationRepository.save(relation);
    }
}
