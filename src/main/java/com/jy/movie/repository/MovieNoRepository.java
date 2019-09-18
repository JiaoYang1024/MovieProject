package com.jy.movie.repository;

import com.jy.movie.entity.MovieNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieNoRepository extends JpaRepository<MovieNo,Long> {



    @Query(nativeQuery = true,value = "select max(movie_no) from movie_no")
    public Long getRecentId();





}
