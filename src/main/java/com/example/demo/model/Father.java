package com.example.demo.model;
/**
 * Created by hzjiaoguangcai on 2017/8/3.
 */
public class Father extends GrandFather {
    public Father() {
        System.out.println();
    }

    @Override
    public void two() {
        System.out.println("Father");
    }
}
