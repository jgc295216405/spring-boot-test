package com.example.demo.model;

/**
 * Created by hzjiaoguangcai on 2017/8/3.
 */
public class GrandFather {
    public GrandFather() {
        System.out.println();
    }

    public void one(){
        GrandFather.this.two();
    }

    public void two() {
        System.out.println("GrandFather");
    }

}
