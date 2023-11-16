package com.dating.repository.post;

import com.dating.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface IPostRepository extends JpaRepository<Post, Integer> {
    /**
     * Method: create,
     * Create: HauNH,
     * Date  : 13/11/2023
     * param : LocalDateTime date, String content, String image, Integer accountId, Integer privacyPostId
     * return: create one post in table post
     */
    @Modifying
    @Query(value = "INSERT INTO post (date, content, image, account_id, privacy_post_id) " +
            "VALUES (:date, :content, :image, :accountId, :privacyPostId)", nativeQuery = true)
    void create(@Param("date") LocalDateTime date, @Param("content") String content,
                @Param("image") String image, @Param("accountId") Integer accountId,
                @Param("privacyPostId") Integer privacyPostId);

    /**
     * Method: showListPublic,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : no
     * return: List<Post> (have privacy is public)
     */
    @Query(value = "SELECT * FROM case.post\n" +
            "where is_deleted = 0 and privacy_post_id = 1", nativeQuery = true)
    List<Post> showListPublic();

    /**
     * Method: showListFriend,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : no
     * return: List<Post> (have privacy is friend)
     */
    @Query(value = "SELECT * FROM case.post\n" +
            "where is_deleted = 0 and privacy_post_id = 2", nativeQuery = true)
    List<Post> showListFriend();

    /**
     * Method: showListOfAnAccount,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : Integer accountId
     * return: List<Post> (displays a list of posts for this account)
     */
    @Query(value = "SELECT * FROM case.post\n" +
            "where is_deleted = 0 and account_id = :accountId", nativeQuery = true)
    List<Post> showListOfAnAccount(@Param("accountId") Integer accountId);
    /**
     * Method: getPostById,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : Integer id
     * return: Post
     */
    @Query(value = "SELECT * FROM case.post\n" +
            "where is_deleted = 0 and id =:id", nativeQuery = true)
    Post getPostById(@Param("id") Integer id);

    /**
     * Method: updateForThePostOwner,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : LocalDateTime date, String content, String image, Integer accountId, Integer privacyPostId,Integer postId
     * return: update one post in table post (for the post owner)
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET content = :content, image = :image,privacy_post_id = :privacyPostId " +
            "WHERE id = :postId AND account_id = :accountId AND is_deleted = 0", nativeQuery = true)
    void updateForThePostOwner(@Param("content") String content,
                               @Param("image") String image, @Param("accountId") Integer accountId,
                               @Param("postId") Integer postId, @Param("privacyPostId") Integer privacyPostId);

    /**
     * Method: updateForAdmin,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : LocalDateTime date, String content, String image, Integer privacyPostId,Integer postId
     * return: update one post in table post (for admin)
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET content = :content, image = :image,privacy_post_id = :privacyPostId " +
            "WHERE id = :postId AND is_deleted = 0", nativeQuery = true)
    void updateForAdmin(@Param("content") String content,
                        @Param("image") String image, @Param("postId") Integer postId,
                        @Param("privacyPostId") Integer privacyPostId);

    /**
     * Method: deleteForAdmin,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : Integer id
     * return: update is_deleted = 1 in table post (for admin)
     */
    @Modifying
    @Query(value = "UPDATE post SET is_deleted = 1 where id =:id and is_deleted = 0", nativeQuery = true)
    void deleteForAdmin(@Param("id") Integer id);

    /**
     * Method: deleteForThePostOwner,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : Integer id
     * return: update is_deleted = 1 in table post (for the post owner)
     */
    @Modifying
    @Query(value = "UPDATE post SET is_deleted = 1 where id =:id and is_deleted = 0 and account_id = :accountId", nativeQuery = true)
    void deleteForThePostOwner(@Param("id") Integer id, @Param("accountId") Integer accountId);
}
