package com.jy.movie.controller;

import com.jy.movie.entity.CommonData;
import com.jy.movie.entity.Movie;
import com.jy.movie.entity.TaiMovie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

   /* @RequestMapping("/getMovieList")
    public CommonData getMovies(){

        Movie movie1 = new Movie("契克","青春片");
        Movie movie2 = new Movie("泰坦尼克号","爱情片");
        Movie movie3 = new Movie("猛龙过江","动作片");
        Movie movie4 = new Movie("月球","科幻片");
        Movie movie5 = new Movie("电锯惊魂","惊悚片");
        List<Movie> movieList = new ArrayList<>();

            movieList.add(movie1);
            movieList.add(movie2);
            movieList.add(movie3);
            movieList.add(movie4);
            movieList.add(movie5);
        CommonData data = new CommonData(true,movieList);
        return data;
    }*/

    /*@RequestMapping("/getMovieList")
    public String getMovies(){

        return "泰坦尼克号,泰坦尼克号";
    }*/

    @RequestMapping("/getMovieList")
    public String getMovies(){



        TaiMovie movie = new TaiMovie();


        return "名称："+movie.getName()+"类型："+movie.getType();
    }
}
