package com.dating.service.comment;

import com.dating.model.comment.Comments;
import com.dating.repository.comment.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository iCommentRepository;

    @Override
    public void deleteComments(int id) {
        iCommentRepository.deleteComment(id);
    }

    @Override
    public Comments findCommentById(int id) {
        return iCommentRepository.findCommentById(id);
    }

    @Override
    public List<Comments> getAllComments() {
        return iCommentRepository.getAllComment();
    }

    @Override
    public void saveComment(Comments comments) {
        iCommentRepository.createComments(comments);
    }

    @Override
    public void editComment(int id, Comments comments) {
        iCommentRepository.editComment(id, comments);
    }
}
