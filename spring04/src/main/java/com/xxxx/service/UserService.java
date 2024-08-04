package com.xxxx.service;

import com.xxxx.dao.IUserDao;
import com.xxxx.dao.UserDao;

import javax.annotation.Resource;

/**
 * @Resource 自动注入（反射）
 *  1、默认根据属性字段名查找
 *  2、如果属性字段名未找到，则通过类型(class类型)查找
 *  3、属性字段可以通过set方法，也可以不提供
 *  4、注解可以声明在属性字段上，也可以申明在set方法上
 *  5、可以通过设置注解的name属性，通过指定值查找bean对象
 *  6、如果注入的是接口，接口只有一个实现类时，可以正常使用，如果接口存在多个实现类，则需要使用name属性指定要注入的bean对象
 */
public class UserService {

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 注入接口
    @Resource
    private IUserDao iUserDao;
    public void test(){
        System.out.println("UserService...");

        userDao.test();
        iUserDao.test();
    }
}
