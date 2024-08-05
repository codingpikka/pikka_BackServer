package com.ohgiraffers.condingpikka_user.post.controller;


import com.ohgiraffers.condingpikka_user.post.model.PostDTO;
import com.ohgiraffers.condingpikka_user.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @GetMapping("/hello")
    public Map<String, String> post(){

        HashMap<String, String> map = new HashMap<>();
        return map;
    }

    @PostMapping("/hello")
    public Map<String, String> post(PostDTO postDTO){
        HashMap<String, String> map = new HashMap<>();
        postService.add(postDTO);
        return map;
    }


}
