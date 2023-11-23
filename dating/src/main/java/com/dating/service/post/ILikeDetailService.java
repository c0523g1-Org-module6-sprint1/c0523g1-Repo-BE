package com.dating.service.post;

import org.springframework.data.repository.query.Param;

public interface ILikeDetailService {
    void insertLikeDetail(@Param("accountId") Integer accountId, @Param("postId") Integer postId);
    void  deleteLike (Integer postId, Integer accountId);
    Integer getAmountLikeOfPost ( Integer postId);
    Boolean checkIsLiked ( Integer postId,  Integer accountId);


}
