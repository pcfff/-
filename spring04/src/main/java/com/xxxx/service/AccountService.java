package com.xxxx.service;

import com.xxxx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Autowired注解实现自动注入（反射）
 * 1、默认根据class类型查找 与属性字段名无关
 * 2、属性字段可以提供setter方法，也可以不提供
 * 3、注解可以设置在属性字段级别或set方法级别
 * 4、可以结合@Qualifier设置别名
 */
public class AccountService {
    @Autowired
    @Qualifier(value = "ud")
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test(){
        System.out.println("AccountService...");
        userDao.test();
    }
}
