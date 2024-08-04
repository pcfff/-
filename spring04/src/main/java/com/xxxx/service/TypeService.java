package com.xxxx.service;

import com.xxxx.dao.TypeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TypeService {
    @Resource
    private TypeDao typeDao;

    public void test(){
        System.out.println("TypeService...");
        typeDao.test();
    }
}
