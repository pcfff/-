package com.xxxx.controller;

import com.xxxx.service.TypeService;
import com.xxxx.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @Resource
    private TestUtil testUtil;

    public void test(){
        System.out.println("TypeController...");
        typeService.test();
        testUtil.test();
    }

}
