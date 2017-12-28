package com.example.demo.Service;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by hzjiaoguangcai on 2017/8/1.
 */
public class MyMethodValidationInterceptor extends org.springframework.validation.beanvalidation.MethodValidationInterceptor {

    private static Method forExecutablesMethod;

    static {
        try {
            forExecutablesMethod = Validator.class.getMethod("forExecutables");
        } catch (Exception ex) {
            ex.printStackTrace();
//            ExceptionUtils.swallow(ex, false);
        }
    }

    private final ApplicationContext context;

    private Validator validator;

    public MyMethodValidationInterceptor(ApplicationContext context) {
        this.context = context;
    }
    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (forExecutablesMethod == null) {
            return super.invoke(invocation);
        }

        Validated annotation = findAnnotation(invocation);
        if (annotation == null) {
            return invocation.proceed();
        }

        if (validator == null) {
            synchronized (this) {
                if (validator == null) {
                    validator = context.getBean(ValidatorFactory.class).getValidator();
                }
            }
        }

        Set<ConstraintViolation<Object>> result;

        ExecutableValidator executableValidator = validator.forExecutables();
        Method method = invocation.getMethod();
        Class<?>[] groups = annotation.value();
        Object[] objects=invocation.getArguments();
        result = executableValidator.validateParameters(invocation.getThis(), method, invocation.getArguments(), groups);

        if (!result.isEmpty()) {
//            throw buildException(invocation.getMethod(), annotation, result, true);
        }

        Object returnValue = invocation.proceed();

        result = executableValidator.validateReturnValue(invocation.getThis(), method, returnValue, groups);
        if (!result.isEmpty()) {
//            throw buildException(invocation.getMethod(), annotation, result, false);
        }

        return returnValue;
    }
    private Validated findAnnotation(MethodInvocation invocation) {
        Validated annotation = AnnotationUtils.findAnnotation(invocation.getMethod(), Validated.class);
       return annotation;

//        return AnnotationUtils.findAnnotation(invocation.getMethod(), IgnoreValidation.class) == null
//                ? AnnotationUtils.findAnnotation(invocation.getThis().getClass(), Validated.class)
//                : null;
    }

}
