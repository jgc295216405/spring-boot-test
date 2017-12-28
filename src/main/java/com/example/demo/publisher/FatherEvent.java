package com.example.demo.publisher;

import org.springframework.context.ApplicationEvent;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
public abstract class FatherEvent extends ApplicationEvent {
    public FatherEvent(Object source) {
        super(source);
    }
   public  abstract  String getEventContent();
}
