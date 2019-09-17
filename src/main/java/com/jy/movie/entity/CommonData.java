package com.jy.movie.entity;

public class CommonData {

    private boolean success;
    private Object data;

    public CommonData(){}

    public CommonData(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
}
