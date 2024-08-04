package com.xxxx;

import com.xxxx.controller.TypeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start02 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring01.xml");
        TypeController typeController = (TypeController) context.getBean("typeController");
        typeController.test();
    }
}
