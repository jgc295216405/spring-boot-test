package com.example.demo.test;


import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Created by hzjiaoguangcai on 2017/8/21.
 */
public abstract class AbstractClass {
    public abstract String getName();

    public static void main(String[] args) {
        new TypeReference(){}.getType();
    }
}
