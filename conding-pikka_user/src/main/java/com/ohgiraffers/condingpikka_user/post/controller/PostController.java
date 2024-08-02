package com.ohgiraffers.condingpikka_user.post.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/")
    public String list(){
        return "list";

    }

    @GetMapping("/post")
    public String post(){
        return "post";
    }
}
