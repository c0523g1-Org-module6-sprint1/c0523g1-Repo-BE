package com.dating.repository.comment;

import com.dating.model.account.Account;
import com.dating.model.comment.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import javax.xml.stream.events.Comment;
import java.util.List;

public interface ICommentRepository extends JpaRepository<Comments,Integer> {
    /**
     * Method: createComments,
     * Create: ThienLCH,
     * Date  : 13/11/2023
     * param : Comment
     * return: insert into table comments a new comment
     */
    @Transactional
    @Modifying
    @Query(value = "insert into comments (date, content, account_id, post_id, id_deleted) " +
            "values (:#{#comment.date}, :#{#comment.content}, :#{#comment.account}, :#{#comment.post}, false)",nativeQuery = true)
    void createComments(@Param("comment")Comments comments);
    /**
     * Method: getAllComment,
     * Create: ThienLCH,
     * Date  : 13/11/2023
     * param : none
     * return: select all from table comments
     */
    @Query(value = "select * from comments where id_deleted = 0 ",nativeQuery = true)
    List<Comments> getAllComment();

    /**
     * Method: findCommentById,
     * Create: ThienLCH,
     * Date  : 13/11/2023
     * param : Integer id
     * return: select all from table comments with id = ?
     */
    @Query(value = "select * from comments where id = :id ",nativeQuery = true)
    Comments findCommentById(@Param("id") Integer id);

    /**
     * Method: deleteComment,
     * Create: ThienLCH,
     * Date  : 13/11/2023
     * param : Integer id, Integer accountId
     * return: update is_deleted = 1 in table comments (for the comment owner)
     */

    @Transactional
    @Modifying
    @Query(value = "update comments set id_deleted = 1 where id = :id ",nativeQuery = true)
    void deleteComment(@Param("id")Integer id);

    /**
     * Method: Edit Comment,
     * Create: ThienLCH,
     * Date  : 13/11/2023
     * param : Integer id, Account account
     * return: update comment in table comments
     */
    @Transactional
    @Modifying
    @Query(value = "update comments set content = :#{#comment.content} where id = :id ",nativeQuery = true)
    void editComment(@Param("id")Integer id, @Param("comment") Comments comments);
}
