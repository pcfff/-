package com.xxxx;

import com.xxxx.service.AccountService;
import com.xxxx.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.test();

        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.test();
    }
}
