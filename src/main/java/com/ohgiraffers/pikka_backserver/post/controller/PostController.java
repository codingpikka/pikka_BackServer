package com.ohgiraffers.pikka_backserver.post.controller;


import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//확인
@RestController
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/post")
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<PostDTO> posts = postService.getAllPosts(); // 데이터베이스에서 모든 게시글을 조회
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/post")
    public Map<String, String> post(@RequestBody PostDTO postDTO){
        HashMap<String, String> map = new HashMap<>();
        System.out.println("Received postDTO: " + postDTO);
        postService.add(postDTO);
        // 응답 데이터에 필요한 정보를 추가하거나, 성공 메시지를 담아 반환할 수 있습니다.
        map.put("status", "success");
        map.put("message", "Data received successfully");
        return map;
    }
}
