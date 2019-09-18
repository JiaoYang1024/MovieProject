package com.jy.movie.repository;

import com.jy.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpa repository

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByName(String name);

    // Movie findByName(String name);
    @Query(nativeQuery = true,value = "select max(id) from movie")
    public Long getRecentId();

    List<Movie> findAllByTypeNo(Long typeId);
}
