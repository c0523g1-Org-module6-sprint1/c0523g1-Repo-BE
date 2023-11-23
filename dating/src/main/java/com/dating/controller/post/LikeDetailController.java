package com.dating.controller.post;

import com.dating.service.post.ILikeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/like")
public class LikeDetailController {
    @Autowired
    private ILikeDetailService iLikeDetailService;

    @PostMapping("/new")
    public ResponseEntity<String> insertLike(@RequestParam("accountId") Integer accountId, @RequestParam("postId") Integer postId) {
        iLikeDetailService.insertLikeDetail(accountId, postId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success Created Like");
    }

    @DeleteMapping("/{postId}/{accountId}")
    public ResponseEntity<String> removeLike(@PathVariable Integer postId, @PathVariable Integer accountId) {
        iLikeDetailService.deleteLike(postId,accountId);
        return ResponseEntity.status(HttpStatus.OK).body("Success Deleted");
    }

    @GetMapping("/amount/{postId}")
    public ResponseEntity<Integer> getAmountLikeOfPost(@PathVariable Integer postId) {
        Integer amount = iLikeDetailService.getAmountLikeOfPost(postId);
        return ResponseEntity.ok(amount);
    }

    @GetMapping("/isLiked")
    public ResponseEntity<Boolean> checkIsLiked(@RequestParam("postId") Integer postId, @RequestParam("accountId") Integer accountId) {
        Boolean isLiked = iLikeDetailService.checkIsLiked(postId,accountId);
        return ResponseEntity.ok(isLiked);
    }
}
