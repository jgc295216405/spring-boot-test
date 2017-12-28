package com.example.demo.Service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by hzjiaoguangcai on 2017/8/21.
 */
@Service
public class BeanProcessTest implements BeanPostProcessor {
    public BeanProcessTest() {
        System.out.println("构造函数");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before："+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after:"+beanName);
        return bean;
    }
}
