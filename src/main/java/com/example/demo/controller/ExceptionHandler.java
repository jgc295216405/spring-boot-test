package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hzjiaoguangcai on 2017/8/18.
 */
@ControllerAdvice
public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler
//    @ResponseBody
    public Student handle(Exception ex) throws Exception {
        Student student=new Student();
        student.setName("name");
        return student;
    }
}
