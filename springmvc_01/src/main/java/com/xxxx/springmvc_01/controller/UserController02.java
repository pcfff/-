package com.xxxx.springmvc_01.controller;

import com.xxxx.springmvc_01.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController02 {
    /**
     * GET 查询
     * POST 新增 保存
     * PUT 修改 更新
     * DELETE 删除
     */

    @PostMapping("/users")
    public String save(){
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("user delete..."+id);
        return "{'module':'user delete'}";
    }

    @PutMapping("/users")
    public String update(@RequestBody User user){
        System.out.println("user update..."+user);
        return "{'module':'user update'}";
    }

    @GetMapping("/users/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("user getById..."+id);
        return "{'module':'user getById'}";
    }

    @GetMapping("/users")
    public String getAll(){
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }

}
