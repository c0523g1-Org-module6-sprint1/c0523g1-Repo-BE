package com.dating.repository.post;

import com.dating.model.post.Post;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface IPostRepository extends JpaRepository<Post, Integer> {
    /**
     * Method: create,
     * Create: HauNH,
     * Date  : 13/11/2023
     * param : LocalDateTime date, String content, String image, Integer accountId, Integer privacyPostId
     * return: create one post in table post
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO post (date, content, image, account_id, privacy_post_id) " +
            "VALUES (NOW(), :content, :image, :accountId, :privacyPostId)", nativeQuery = true)
    void create( @Param("content") String content,
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
            "where is_deleted = 0 ORDER BY post.date DESC", nativeQuery = true)
    List<Post> showListForAdmin();


    @Query(value = "SELECT COUNT(*) " +
            "FROM relationships " +
            "WHERE ((receiver_account_id = :account1 AND sender_account_id = :account2) " +
            "       OR (receiver_account_id = :account2 AND sender_account_id = :account1)) " +
            "      AND relationship_status_id = 2 " +
            "      AND is_deleted = 0", nativeQuery = true)
    Integer checkIsFriend(@Param("account1") Integer accountId1, @Param("account2") Integer accountId2);


    @Query (value = "select * from post\n" +
            "where account_id = :accountId and privacy_post_id in (1,2) and is_deleted = 0 ORDER BY  post.date DESC",nativeQuery = true)
    List <Post> getListForFriend (@Param("accountId") Integer accountId);

    @Query (value = "select * from post\n" +
            "where account_id = :accountId and privacy_post_id = 1 and is_deleted = 0 ORDER BY  post.date DESC ",nativeQuery = true)
    List <Post> getListForStranger (@Param("accountId") Integer accountId);

    /**
     * Method: showListNewsfeed,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : loggedInAccountId
     * return: List<Post> (have relationship friend and privacy is public or friend)
     */
    @Query(value = "SELECT p.*\n" +
            "FROM post p\n" +
            "WHERE (p.account_id = :loggedInAccountId AND p.privacy_post_id IN (1, 2, 3) AND p.is_deleted = 0)\n" +
            "   OR (p.account_id IN (\n" +
            "        SELECT CASE\n" +
            "                 WHEN r.receiver_account_id = :loggedInAccountId THEN r.sender_account_id\n" +
            "                 ELSE r.receiver_account_id\n" +
            "               END AS friend_id\n" +
            "        FROM relationships r\n" +
            "        WHERE r.relationship_status_id = 2\n" +
            "        AND (r.receiver_account_id = :loggedInAccountId OR r.sender_account_id = :loggedInAccountId)\n" +
            "      )\n" +
            "      AND p.privacy_post_id IN (1, 2))\n" +
            "      AND p.is_deleted = 0\n" +
            "ORDER BY p.date DESC", nativeQuery = true)
    List<Post> showListNewsfeed(@Param("loggedInAccountId") Integer loggedInAccountId);

    /**
     * Method: showListOfAnAccount,
     * Create: DatNC,
     * Date  : 13/11/2023
     * param : String userName
     * return: List<Post> (displays a list of posts for this account)
     */
    @Query(value = "SELECT * FROM case.post\n" +
            "join accounts on post.account_id = accounts.id\n" +
            "where post.is_deleted = 0 and accounts.id = :accountId ORDER BY post.date DESC", nativeQuery = true)
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
