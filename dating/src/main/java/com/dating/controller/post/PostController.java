package com.dating.controller.post;

import com.dating.model.post.Post;
import com.dating.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/newsfeed/post")
public class PostController {
    @Autowired
    private IPostService iPostService;
    @PostMapping("/new")
    public ResponseEntity<String> create (@RequestBody Post post){
        iPostService.create(post.getDate(),post.getContent(), post.getImage(), post.getAccount().getId(),post.getPrivacyPost().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body("Success Created");
    }
}
