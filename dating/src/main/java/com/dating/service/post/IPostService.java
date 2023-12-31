package com.dating.service.post;

import com.dating.model.post.Post;
import com.dating.model.relationship.Relationships;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IPostService {
    boolean create( String content, String image, Integer accountId, Integer privacyId);
    List<Post> showListNewsfeed( Integer loggedInAccountId);
    List<Post> showListOfAnAccount( Integer accountId);
    List<Post> showListForAdmin();
    Boolean checkIsFriend (Integer accountId1, Integer accountId2);
    Post getPostById (Integer id);
    boolean updateForThePostOwner(String content, String image, Integer accountId, Integer postId, Integer privacyPostId);
    boolean updateForAdmin(String content, String image, Integer postId, Integer privacyPostId);
    boolean deleteForAdmin(Integer id);
    boolean deleteForThePostOwner(Integer id,Integer accountId);
    List <Post> getListForFriend (@Param("accountId") Integer accountId);
    List <Post> getListForStranger (@Param("accountId") Integer accountId);


}
