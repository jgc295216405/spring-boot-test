package com.example.demo.Service;

import com.example.demo.test.Animal;
import com.example.demo.test.Create;
import com.example.demo.test.Update;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;


/**
 * Created by hzjiaoguangcai on 2017/8/1.
 */
public interface ValidateService {
//    default String say(String name) {
//        return "hello" + name;
//    }
    @Validated(Update.class)
    void valid(@NotEmpty(groups = Create.class) String name);
}
