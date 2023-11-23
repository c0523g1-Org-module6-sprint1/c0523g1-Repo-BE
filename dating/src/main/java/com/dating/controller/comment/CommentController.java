package com.dating.controller.comment;

import com.dating.dto.comment.CommentDto;
import com.dating.model.account.Account;
import com.dating.model.comment.Comments;
import com.dating.model.post.Post;
import com.dating.service.account.IAccountService;
import com.dating.service.comment.ICommentService;
import com.dating.service.post.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IPostService iPostService;
    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: show list comment
     *
     * @return HttpStatus
     */

    @GetMapping("/comment")
    public ResponseEntity<List<Comments>> showList() {
        List<Comments> commentList = iCommentService.getAllComments();
        if (commentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        }
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Object> getComment(@PathVariable Integer id) {
        Comments comments = iCommentService.findCommentById(id);
        if (comments == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: delete comment
     *
     * @return HttpStatus
     */
    //
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete failed ");
        }
        iCommentService.deleteComments(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success deleted");
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: create comment
     *
     * @return HttpStatus
     */
    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<Object> createComment(@RequestBody CommentDto commentDto) {
        if (commentDto.getContent().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail to create");
        }
        Comments comments = new Comments();
        BeanUtils.copyProperties(commentDto,comments);
        Account account = iAccountService.findAccountById(commentDto.getAccountId());
        LocalDateTime dateTime = LocalDateTime.now();
        comments.setDate(dateTime);
        comments.setAccount(account);
        Post post = iPostService.getPostById(commentDto.getPostId());
        comments.setPost(post);
        iCommentService.saveComment(comments);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit comment
     *
     * @return HttpStatus
     */

    @PutMapping("/comment/{id}")
    public ResponseEntity<Object> editComment(@Valid @PathVariable Integer id,
                                              CommentDto commentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Updated Fail");
        }
        if (iCommentService.findCommentById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Updated Fail");
        }
        Comments comments = new Comments();
        BeanUtils.copyProperties(commentDto, comments);
        iCommentService.editComment(id, comments);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Created");
    }
}
