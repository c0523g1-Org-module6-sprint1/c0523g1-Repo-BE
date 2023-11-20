package com.dating.service.comment;

import com.dating.model.comment.Comments;

import java.util.List;

/**
 * Method: Comments Interface,
 * Create: ThienLCH,
 * Date  : 13/11/2023
 *
 * return:
 */

public interface ICommentService {
    void deleteComments(int id);

    Comments findCommentById(int id);

    List<Comments> getAllComments();
    List<Comments> getAllCommentsByAccountId(Integer id);
    List<Comments> getAllCommentsByPost_id(Integer id);

    void saveComment(Comments comments);

    void editComment(int id, Comments comments);
}
