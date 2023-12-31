package com.dating.controller.post;

import com.dating.dto.post.PostDto;
import com.dating.dto.post.UpPostDto;
import com.dating.model.post.Post;
import com.dating.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/post")
public class PostController {
    @Autowired
    private IPostService iPostService;
    @GetMapping("/newsfeed/{loggedInAccountId}")
    public ResponseEntity<List<Post>> showListNewsfeed(@PathVariable Integer loggedInAccountId) {
        List<Post> posts = iPostService.showListNewsfeed(loggedInAccountId);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Post>> showListForAdmin() {
        List<Post> posts = iPostService.showListForAdmin();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Post>> showListOfAnAccount(@PathVariable Integer accountId) {
        List<Post> posts = iPostService.showListOfAnAccount(accountId);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
        Post post = iPostService.getPostById(postId);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
    }

    @GetMapping("/friend/{accountId}")
    public ResponseEntity<List<Post>> getListForFriend(@PathVariable Integer accountId) {
        List<Post> posts = iPostService.getListForFriend(accountId);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/stranger/{accountId}")
    public ResponseEntity<List<Post>> getListForStranger (@PathVariable Integer accountId) {
        List<Post> posts = iPostService.getListForStranger(accountId);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody UpPostDto post) {
        boolean check = iPostService.create(post.getContent(), post.getImage(), post.getAccountId(), post.getPrivacyPostId());
        if (check) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Success Created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create post");
        }
    }

    @PatchMapping("/post-owner/{accountId}/{postId}")
    public ResponseEntity<String> updateForThePostOwner(@PathVariable Integer accountId, @PathVariable Integer postId, @RequestBody Post post) {
        boolean check = iPostService.updateForThePostOwner(post.getContent(), post.getImage(), accountId, postId, post.getPrivacyPost().getId());
        if (check) {
            return ResponseEntity.status(HttpStatus.OK).body("Updated Created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update post");
        }
    }

    @PatchMapping("/admin/{postId}")
    public ResponseEntity<String> updateForAdmin(@PathVariable Integer postId, @RequestBody PostDto postDto) {
        boolean check = iPostService.updateForAdmin(postDto.getContent(), postDto.getImage(), postId, postDto.getPrivacyPostId());
        if (check) {
            return ResponseEntity.status(HttpStatus.OK).body("Updated Created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update post");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteForAdmin(@PathVariable Integer id) {
        boolean check = iPostService.deleteForAdmin(id);
        if (check) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete post");
        }
    }

    @DeleteMapping("/{id}/{accountId}")
    public ResponseEntity<String> deleteForThePostOwner(@PathVariable Integer id, @PathVariable Integer accountId) {
        boolean check = iPostService.deleteForThePostOwner(id, accountId);
        if (check) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete post");
        }
    }

    @GetMapping("/isFriend")
    public ResponseEntity<Boolean> checkIsFriend (@RequestParam Integer accountId1, Integer accountId2){
        Boolean isFriend = iPostService.checkIsFriend(accountId1,accountId2);
        return ResponseEntity.ok(isFriend);
    }
}
