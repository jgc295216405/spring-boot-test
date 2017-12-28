package com.example.demo.test.annotion;

import java.lang.reflect.Method;

@Student
public class Annotation {
    public static void main(String[] args) throws NoSuchMethodException {
        Class c=Annotation.class;
     java.lang.annotation.Annotation parent =c.getAnnotation(Parent.class);
     System.out.println(parent);
        java.lang.annotation.Annotation stu =c.getAnnotation(Student.class);
        System.out.println(stu);
//        java.lang.annotation.Annotation annotation =c.getAnnotation(Parent.class);
       Method method= c.getMethod("ann",String[].class);
        java.lang.annotation.Annotation methodAnn =method.getAnnotation(Parent.class);
        System.out.println(methodAnn);
    }
    @Student
    public  void ann(String[] args) {

    }
}
