package com.example.demo.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
@Component
public class PeopleListener {
    @EventListener
    @Async
    public void onApplicationEvent(PeopleEvent ue) {
//        if(applicationEvent instanceof PeopleEvent){ //只对UserEvent类型进行处理
//            PeopleEvent ue = (PeopleEvent)applicationEvent;
            String result = ue.getEventContent();
            System.out.println("##########"+result);
        Service peopleService=(Service)ue.getSource();
            peopleService.say();
//        }
    }
}
