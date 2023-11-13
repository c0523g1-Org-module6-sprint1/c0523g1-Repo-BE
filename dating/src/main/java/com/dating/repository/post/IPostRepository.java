package com.dating.repository.post;

import com.dating.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface IPostRepository extends JpaRepository<Post,Integer> {
    @Modifying
    @Query(value = "INSERT INTO your_table (date, content, image, account_id, privacy_post_id) " +
            "VALUES (:date, :content, :image, :accountId, :privacyPostId)", nativeQuery = true)
    void create(@Param("date") LocalDateTime date, @Param("content") String content,
                    @Param("image") String image, @Param("accountId") Integer accountId,
                    @Param("privacyPostId") Integer privacyPostId);
}
