package com.example.demo.publisher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
@Service
public class PeopleService implements ApplicationContextAware, com.example.demo.publisher.Service {
    private ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
    public void service(String thing)
    {
        PeopleEvent event = new PeopleEvent(this,thing);
        event.setEventContent("People:"+thing);
        applicationContext.publishEvent(event);
    }
    public void say()
    {
        System.out.println("People say()");
    }

    public static void main(String[] args) {

    }
}
