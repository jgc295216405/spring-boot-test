package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzjiaoguangcai on 2017/8/10.
 */
@Service
public class ServiceB implements com.example.demo.Service.Service{
    public ServiceB() {
        System.out.println("ServiceB");
    }

    @Autowired
    private ServiceA serviceA;
//    @Autowired
//    public ServiceB( ServiceA serviceA) {
//        this.serviceA=serviceA;
//    }
public String main() {
    return "a";
}
}
