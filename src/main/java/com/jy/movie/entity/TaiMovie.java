package com.jy.movie.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaiMovie {

    @Value("${movie.name}")
    private String name;
    @Value("${movie.type}")
    private String type;

    public TaiMovie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
