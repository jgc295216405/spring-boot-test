package com.example.demo.Service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzjiaoguangcai on 2017/8/10.
 */
@Service
public class ServiceA implements BeanNameAware,BeanFactoryAware, com.example.demo.Service.Service {
    @Autowired
    private ServiceB serviceB;
    String beanName;

    public ServiceA() {
        System.out.println("构造函数ServiceA");
    }

    @Override
    public void setBeanName(String name) {
        beanName=name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
//    @Autowired
//    public ServiceA( ServiceB serviceB) {
//        this.serviceB=serviceB;
//    }
}
