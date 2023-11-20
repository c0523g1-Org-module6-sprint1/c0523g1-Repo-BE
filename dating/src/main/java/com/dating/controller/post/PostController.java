package com.dating.controller.post;

import com.dating.dto.post.PostDto;
import com.dating.model.post.Post;
import com.dating.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/newsfeed/post")
public class PostController {
    @Autowired
    private IPostService iPostService;

    @GetMapping("/public")
    public ResponseEntity<List<Post>> showListPublic() {
        List<Post> posts = iPostService.showListPublic();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/friend")
    public ResponseEntity<List<Post>> showListFriend() {
        List<Post> posts = iPostService.showListFriend();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/account/{userName}")
    public ResponseEntity<List<Post>> showListOfAnAccount(@PathVariable String userName) {
        List<Post> posts = iPostService.showListOfAnAccount(userName);
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

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody Post post) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formattedDateTime = LocalDateTime.parse(dateTime.format(formatter));



        boolean check = iPostService.create(formattedDateTime, post.getContent(), post.getImage(), post.getAccount().getId(), post.getPrivacyPost().getId());
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
}
