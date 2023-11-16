package com.dating.service.comment;

import com.dating.model.comment.Comments;

import java.util.List;

public interface ICommentService {
    void deleteComments(int id);

    Comments findCommentById(int id);

    List<Comments> getAllComments();

    void saveComment(Comments comments);

    void editComment(int id, Comments comments);
}
