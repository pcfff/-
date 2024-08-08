package com.xxxx.springmvc_01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping("/book/save")
    public String save() {
        System.out.println("book save ... ");
        return "{'module':'book save'}";
    }
}
