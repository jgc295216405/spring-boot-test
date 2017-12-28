package com.example.demo.test;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by hzjiaoguangcai on 2017/7/5.
 */
public class Animal implements Serializable{
    private static final long serialVersionUID = 3893285178322836196L;
    @NotNull(groups = {Update.class},message = "a can not null")
    private Integer a;
    @NotEmpty(groups = {Create.class,Update.class},message  = "b can not null")
    private String b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args) {

    }

}
