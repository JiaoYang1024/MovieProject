package com.jy.movie.repository;

import com.jy.movie.entity.MovieActorRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieActorRelationRepository extends JpaRepository<MovieActorRelation,Long> {
    List<MovieActorRelation> findAllByMovieId(Long movieId);
}
