package com.example.demo.publisher;

import org.springframework.context.ApplicationEvent;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
public class UserEvent extends FatherEvent {
    private String eventContent;
    public String getEventContent(){
        return eventContent;
    }
    public void setEventContent(String eventContent){
        this.eventContent = eventContent;
    }
    public UserEvent(Object source,String eventContent){
        super(source);
        this.eventContent = eventContent;
    }
}
