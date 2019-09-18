package com.jy.movie.service;

import com.jy.movie.entity.MovieActorRelation;
import com.jy.movie.repository.MovieActorRelationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MovieActorRelationService {


    MovieActorRelationRepository movieActorRelationRepository;


    public void saveRelations(List<MovieActorRelation> relationList) {
        System.out.println("=================================");
        System.out.println(relationList.size());
        System.out.println(relationList.get(0).toString());
        System.out.println("===================================");
        movieActorRelationRepository.saveAll(relationList);
    }

    public void saveRelation(MovieActorRelation relation) {
        movieActorRelationRepository.save(relation);
    }
}
