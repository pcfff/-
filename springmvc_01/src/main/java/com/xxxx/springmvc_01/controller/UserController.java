package com.xxxx.springmvc_01.controller;

import com.xxxx.springmvc_01.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/commonParam")
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递name ==> " + name);
        System.out.println("普通参数传递age ==> " + age);
        return "{'module':'common param'}";
    }

    // 普通参数
    @RequestMapping("/commonParamDifferentName")
    public String commonParamDifferentName(@RequestParam("name") String userName, @RequestParam("age") int age) {
        System.out.println("普通参数传递name ==> " + userName);
        System.out.println("普通参数传递age ==> " + age);
        return "{'module':'common param different name'}";
    }

    // pojo参数
    @RequestMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println("pojo参数传递user ==> "+user);
        return "{'module':'pojo param'}";
    }

    // 嵌套pojo参数
    @RequestMapping("/pojoContainPojoParam")
    public String pojoContainPojoParam(User user) {
        System.out.println("pojo嵌套pojo参数传递  user ==> "+user);
        return "{'module':'pojo contain pojo param'}";
    }

    // 数组参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递likes ==>" + Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    // 集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 likes ==>" + likes);
        return "{'module':'list param'}";
    }

    // 集合参数：json格式
    @RequestMapping("/listParamForJson")
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> "+likes);
        return "{'module':'list param for json'}";
    }

    // pojo参数 json格式
    @RequestMapping("/pojoParamForJson")
    public String pojoParamForJson(@RequestBody User user) {
        System.out.println("pojo(json)参数传递 user ==> "+user);
        return "{'module':'pojo param for json'}";
    }

    // 集合参数 json格式
    @RequestMapping("/listPojoParamForJson")
    public String listPojoParamForJson(@RequestBody List<User> list) {
        System.out.println("list pojo(json)参数传递 list ==> "+list)    ;
        return "{'module':'list pojo param for json'}";
    }

    // 日期参数
    @RequestMapping("/dataParam")
    public String dataParam(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1) {
        System.out.println("参数传递 date ==>" +date);
        System.out.println("参数传递 date1 ==>" +date1);
        return "{'module':'data param'}";
    }
}
