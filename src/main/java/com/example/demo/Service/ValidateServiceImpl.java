package com.example.demo.Service;

import com.example.demo.test.Animal;
import com.example.demo.test.Create;
import org.aopalliance.aop.Advice;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Validator;

/**
 * Created by hzjiaoguangcai on 2017/8/1.
 */
@Service
public class ValidateServiceImpl implements ValidateService {
    private ApplicationContext context;

    @Override
    public void valid(String animal) {
        System.out.println(animal);

    }
}
