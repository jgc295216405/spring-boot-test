package com.example.demo.controller;

/**
 * Created by hzjiaoguangcai on 2017/6/23.
 */

import com.example.demo.Service.ServiceA;
import com.example.demo.Service.ServiceB;
import com.example.demo.Service.ServiceC;
import com.example.demo.Service.ValidateService;
import com.example.demo.model.Student;
import com.example.demo.publisher.PeopleListener;
import com.example.demo.publisher.PeopleService;
import com.example.demo.publisher.UserService;
import com.example.demo.test.Animal;
import com.example.demo.test.Create;
import com.example.demo.test.Update;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HELLO 控制器
 */
@Controller
public class HelloController {
    @Autowired
    private ServiceC serviceC;
    @Autowired
    ResourceLoader resourceLoader;
  @Autowired
  private ValidateService validateService;
    @Autowired
    private UserService userService;
   @Autowired
   private ServiceA  serviceA;
   @Autowired
   private ServiceB serviceB;
    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ApplicationContext applicationContext;
    @ResponseBody
    @RequestMapping(value = "/valid")
    public Long testValid(String a, HttpServletRequest request) throws IOException {
//        userService.service("jgc user");
//        peopleService.service("jgc people" );
//        System.out.println("over...........");
        return new Long("40996352909377536");
    }
    @RequestMapping(value = "/create")
    public String test1(@Validated(Create.class) Animal animal) throws IOException {
//        validateService.valid(null);
        return "test";
    }
    @RequestMapping(value = "/update")
    public String update(@Validated({Update.class}) Animal animal) throws IOException {
        return "test";
    }
    @RequestMapping(value = "/zhujie")
    public String zhujie() throws IOException {


        return "test";
    }

    @ResponseBody
    @RequestMapping(value = "/json")
    public Student json(ModelMap modelMap,String a) {
        return new Student("jgc", 12);
    }
    @RequestMapping(value = "/redirect")
    public String zhujie(HttpServletRequest request, HttpServletResponse response,String a) throws IOException {
        if(a.equals("1")) {
            response.sendRedirect("http://www.baidu.com");
        }
        return "test";
//        response.sendRedirect("/json");
//        return new ModelAndView("redirect:http://www.baidu.com");
    }

    @RequestMapping(value = "/forward")
    public ModelAndView forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect();
//        request.getRequestDispatcher("http://www.baidu.com");
        request.getRequestDispatcher("/json").forward(request, response);
//        return new ModelAndView("forward:/json");
        return null;
    }
}
