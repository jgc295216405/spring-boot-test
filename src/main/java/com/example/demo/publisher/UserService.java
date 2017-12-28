package com.example.demo.publisher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
@Service
public class UserService implements ApplicationContextAware, com.example.demo.publisher.Service {
    private ApplicationContext applicationContext;

    public UserService() {
        System.out.println("UserService");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("applicationContext:UserService");
        this.applicationContext = applicationContext;
    }
    public void service(String thing)
    {
        UserEvent event = new UserEvent(this,thing);
        event.setEventContent("user: "+thing);
        applicationContext.publishEvent(event);
    }
    public void say()
    {
        System.out.println("user say()");
    }
}
