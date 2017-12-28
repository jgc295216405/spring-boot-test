package com.example.demo.Service;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

/**
 * Created by hzjiaoguangcai on 2017/8/1.
 */
@Component
public class MethodAdvice  extends MethodValidationPostProcessor implements ApplicationContextAware  {
    private ApplicationContext context;

    private Validator validator;

    @Override
    public void afterPropertiesSet() {
        Pointcut pointcut = new AnnotationMatchingPointcut(null, Validated.class);
        this.advisor = new DefaultPointcutAdvisor(pointcut, createMethodValidationAdvice(this.validator));
    }

    @Override
    protected Advice createMethodValidationAdvice(Validator validator) {
        return validator == null ? new MyMethodValidationInterceptor(context) : super.createMethodValidationAdvice(validator);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
