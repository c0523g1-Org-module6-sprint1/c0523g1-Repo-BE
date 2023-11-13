package com.dating.repository.post;

import com.dating.model.post.PrivacyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrivacyPostRepository extends JpaRepository<PrivacyPost,Integer>{
    /**
     * Method: showListPrivacyPost,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : no
     * return: List<PrivacyPost>
     */
    @Query(value = "select * from privacy_post where is_deleted = 0",nativeQuery = true)
    List<PrivacyPost> showListPrivacyPost ();

}
