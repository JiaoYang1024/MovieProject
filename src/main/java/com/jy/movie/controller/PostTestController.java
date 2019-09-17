package com.jy.movie.controller;

import com.jy.movie.entity.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("postMovies")
public class PostTestController {

   private List<String> movieList = new ArrayList<>(Arrays.asList("泰坦尼克号","电锯惊魂","笑傲江湖"));



    //访问 localhost:7777/movies   返回["泰坦尼克号","电锯惊魂","笑傲江湖"]
    @PostMapping
    public List getMovies(){

        return movieList;
    }

    //访问 localhost:7777/movies/0   返回"泰坦尼克号"
    //@PathVariable 注解，拿取地址中拼接的值
    @PostMapping("/{id}")
    public String getMovieById(@PathVariable int id){

        return movieList.get(id);
    }


    //http://localhost:7777/movies/chooseMovie1?id=2&name=11
    //@RequestParam注解，用postman测试，在params中添加数据，可以打印出
    //在body中添加数据，也同样可以，无论是form-data还是x-www-form-urlencoded都行.put请求也一样，放哪里都行
    @PostMapping("/chooseMovie1")
    public String getMovieById1(@RequestParam int id,@RequestParam String name){
        return movieList.get(id);
    }


    //http://localhost:7777/movies/chooseMovie1?id=2&name=11
    //@RequestParam注解，用postman测试，在params中添加数据，可以打印出
    //在body中添加数据，也同样可以，无论是form-data还是x-www-form-urlencoded都行.put请求也一样，放哪里都行
    @PostMapping("/chooseMovie11")
    public String getMovieById11(@RequestParam Movie movie){
        System.out.println(movie.toString());
        return movieList.get(0);
    }

    //http://localhost:7777/movies/chooseMovie2

    //用postman测试，在params中传参数可以
    // 也可以在Body中添加数据，而且是在x-www-form-urlencoded中，在form-data中不行
    //如添加两个键值对：id：0，name:3
    //打印传递过来的参数String类型的id，显示id=0&name=3
    @PostMapping("/chooseMovie2")
    public String getMovieById2(@RequestBody String id){  //参数类型必须为String,其他基本类型都不行，类也不行
        System.out.println(id);
        return movieList.get(0);
    }
    @PostMapping("/chooseMovie21")          //好像是跟postman请求时，headers里的content-type有关系
    public String getMovieById21(@RequestBody int id){  //参数类型必须为String,其他基本类型都不行，类也不行
        System.out.println(id);
        return movieList.get(id);
    }
    @PostMapping("/chooseMovie22")
    public String getMovieById22(@RequestBody Movie movie){  //参数类型必须为String,其他基本类型都不行，类也不行
        System.out.println(movie.toString());
        return movieList.get(0);
    }
    //http://localhost:7777/movies/chooseMovie3
    //用postman测试，需要在Body中添加数据，
    // 在x-www-form-urlencoded中添加数据的话，无法映射到movie中，打印出来的movie属性都为null，但接口可以访问成功
    // 在form-data中添加数据，可以映射到movie中，如果参数没写全，movie中的部分属性为null

    //用postman测试，在params中添加数据也可以。会把数据根据名字映射成对象的属性，没有的，对象的属性就为null
    //如果在postman中测试时，在params中和body中都添加了数据，比如都添加了name属性，则映射出来，name属性就成了String类型的数组或list
   // http://localhost:7777/movies/chooseMovie3?name=1&type=2
    @PostMapping("/chooseMovie3")
    public String getMovieById3(@ModelAttribute Movie movie){  //参数类型为对象类型
        System.out.println(movie.toString());
        return movieList.get(0);
    }

    @PostMapping("/chooseMovie4")
    public String getMovieById4(@ModelAttribute String id){
        //参数类型为对象类型,可以，能打印出来
        // int类型不行，接口访问报错
        //String类型可以访问成功，用postman测试，数据写在params中，什么都打印不出来，写在body中，也打印不出来

        System.out.println(id);
        return movieList.get(1);
    }
}
