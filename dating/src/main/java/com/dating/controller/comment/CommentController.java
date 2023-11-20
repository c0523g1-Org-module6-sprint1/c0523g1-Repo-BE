package com.dating.controller.comment;

import com.dating.dto.comment.CommentDto;
import com.dating.model.comment.Comments;
import com.dating.service.comment.ICommentService;
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
     * goal: delete comment
     *
     * @return HttpStatus
     */
    @PostMapping("/comment")
    public ResponseEntity<Object> createComment(@RequestBody Comments comments, BindingResult bindingResult) {
        if (comments.getContent().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail to create");
        }
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Updated Fail");
        }
        Comments comments = new Comments();
        BeanUtils.copyProperties(commentDto, comments);
        iCommentService.editComment(id, comments);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Created");
    }
}
