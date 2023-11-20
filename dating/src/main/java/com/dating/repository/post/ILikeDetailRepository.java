package com.dating.repository.post;

import com.dating.model.post.LikeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ILikeDetailRepository extends JpaRepository<LikeDetail,Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO like_detail (date, account_id, post_id) " +
            "VALUES (NOW(), :accountId, :postId)", nativeQuery = true)
    void insertLikeDetail(@Param("accountId") Integer accountId, @Param("postId") Integer postId);

    @Query (value = "select * from like_detail", nativeQuery = true)
    List<LikeDetail> findAllLikeDetail ();

    @Query (value = "SELECT COUNT(*) AS like_count\n" +
            "FROM like_detail\n" +
            "WHERE post_id = :postId and is_deleted = 0", nativeQuery = true)
    Integer getAmountLikeOfPost (@Param("postId") Integer postId);

    @Query (value = "SELECT COUNT(*) FROM like_detail WHERE post_id = :postId AND account_id = :accountId AND is_deleted = 0",nativeQuery = true)
    Integer getAmountLikeOfPostOfAccount (@Param("postId") Integer postId, @Param("accountId") Integer accountId);
    @Transactional
    @Modifying
    @Query(value = "delete from like_detail where account_id = :accountId and post_id = :postId and is_deleted = 0",nativeQuery = true)
    void  deleteLike (@Param("postId") Integer postId, @Param("accountId") Integer accountId);
}
