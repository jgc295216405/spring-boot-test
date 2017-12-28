package com.example.demo.publisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by hzjiaoguangcai on 2017/7/24.
 */
@Component
@EnableAsync
public class UserListener {
    @EventListener
    @Async
    public void consumer(FatherEvent ue) throws InterruptedException {
//        if(applicationEvent instanceof UserEvent){ //只对UserEvent类型进行处理
//            UserEvent ue = (UserEvent)applicationEvent;

            Thread.sleep(5000);
            String result = ue.getEventContent();
            System.out.println("******111111:"+result);
            Service userService=(Service)ue.getSource();
            userService.say();
//        }
    }
    @EventListener
    @Async
    public void consumer2(FatherEvent ue) {
//        if(applicationEvent instanceof UserEvent){ //只对UserEvent类型进行处理
//            UserEvent ue = (UserEvent)applicationEvent;
        String result = ue.getEventContent();
        System.out.println("******:"+result);
        Service userService=(Service)ue.getSource();
        userService.say();

//        }
    }
}
