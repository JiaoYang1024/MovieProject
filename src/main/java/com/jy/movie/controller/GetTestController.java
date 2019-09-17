package com.jy.movie.controller;

import com.jy.movie.entity.Movie;
import com.jy.movie.entity.TaiMovie;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("getMovies")
public class GetTestController {

   private List<String> movieList = new ArrayList<>(Arrays.asList("泰坦尼克号","电锯惊魂","笑傲江湖"));



    //访问 localhost:7777/movies   返回["泰坦尼克号","电锯惊魂","笑傲江湖"]
    @GetMapping
    public List getMovies(){

        return movieList;
    }

    //访问 localhost:7777/movies/0   返回"泰坦尼克号"
    //@PathVariable 注解，拿取地址中拼接的值
    @GetMapping("/{id}")
    public String getMovieById(@PathVariable int id){

        return movieList.get(id);
    }


    //http://localhost:7777/movies/chooseMovie1?id=2&name=11
    //@RequestParam注解，用postman测试，在params中添加数据，可以打印出
    //不用params添加数据，用body添加数据的话，只能用form-data，不能用x-www-form-urlencoded
    //如果同时在params和body中添加数据,则采用的是body中的。
    // 跟body里采取的是xxx还是form-data有关系。如果是xxx，还是用params的。如果是form-data,则用body里的


    //params里的参数和body里xxx里的参数，params的优先级高。
    //params里的参数和body里data-form里的参数，data-form的优先级高。
    @GetMapping("/chooseMovie1")
    public String getMovieById1(@RequestParam int id,@RequestParam String name){
        return movieList.get(id);
    }


    //http://localhost:7777/movies/chooseMovie2
    //用postman测试，需要在Body中添加数据，而且是在x-www-form-urlencoded中，在form-data中不行
    //在params中传递不行，但是Post请求可以
    //如添加两个键值对：id：0，name:3
    //打印传递过来的参数String类型的id，显示id=0&name=3
    @GetMapping("/chooseMovie2")
    public String getMovieById2(@RequestBody String id){  //参数类型必须为String,其他基本类型都不行，类也不行
        System.out.println(id);
        return movieList.get(0);
    }


    //http://localhost:7777/movies/chooseMovie3
    //用postman测试，需要在Body中添加数据，
    // 在x-www-form-urlencoded中添加数据的话，无法映射到movie中，打印出来的movie属性都为null，但接口可以访问成功
    // 在form-data中添加数据，可以映射到movie中，如果参数没写全，movie中的部分属性为null

    //用postman测试，在params中添加数据也可以。会把数据根据名字映射成对象的属性，没有的，对象的属性就为null
    //如果在postman中测试时，在params中和body中都添加了数据，比如都添加了name属性，则映射出来，name属性就成了String类型的数组或list
   // http://localhost:7777/movies/chooseMovie3?name=1&type=2
    @GetMapping("/chooseMovie3")
    public String getMovieById3(@ModelAttribute Movie movie){  //参数类型为对象类型
        System.out.println(movie.toString());
        return movieList.get(0);
    }

    @GetMapping("/chooseMovie4")
    public String getMovieById4(@ModelAttribute String id){
        //参数类型为对象类型,可以，能打印出来
        // int类型不行，接口访问报错
        //String类型可以访问成功，用postman测试，数据写在params中，什么都打印不出来，写在body中，也打印不出来

        System.out.println(id);
        return movieList.get(1);
    }
}
