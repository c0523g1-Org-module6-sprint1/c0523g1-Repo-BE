package com.dating.repository.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.account.Account;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecommendFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findAllRecommendFriend
     * Create HungHLP
     * Date 13-11-2023
     * return list  recommend friend
     */

    @Query(value = "SELECT \n" +
            "    location.name AS location,\n" +
            "    jobs.name AS job,\n" +
            "    hobbies.name AS hobby,\n" +
            "    genders.name AS gender,\n" +
            "    accounts.name AS name,\n" +
            "    accounts.avatar AS avatar,\n" +
            "    accounts.id AS id\n" +
            "FROM \n" +
            "    location\n" +
            "LEFT JOIN \n" +
            "    accounts ON accounts.location_id = location.id\n" +
            "LEFT JOIN \n" +
            "    jobs ON accounts.job_id = jobs.id\n" +
            "LEFT JOIN \n" +
            "    hobby_detail ON hobby_detail.account_id = accounts.id\n" +
            "LEFT JOIN \n" +
            "    hobbies ON hobby_detail.hobby_id = hobbies.id\n" +
            "LEFT JOIN \n" +
            "    genders ON accounts.gender_id = genders.id\n" +
            "WHERE \n" +
            "    (jobs.id = (\n" +
            "        SELECT accounts.job_id\n" +
            "        FROM accounts\n" +
            "        WHERE accounts.id = :accountID\n" +
            "    ) or\n" +
            "    hobbies.id = (\n" +
            "        SELECT hobby_detail.hobby_id\n" +
            "        FROM hobby_detail\n" +
            "        WHERE hobby_detail.account_id = :accountID\n" +
            "    ) \n" +
            "    AND NOT EXISTS (\n" +
            "        SELECT :accountID\n" +
            "        FROM relationships r\n" +
            "        WHERE \n" +
            "            (r.sender_account_id = accounts.id AND r.receiver_account_id = :accountID)\n" +
            "            OR (r.sender_account_id = :accountID AND r.receiver_account_id = accounts.id)\n" +
            "            AND r.relationship_status_id IN (1, 2, 3) -- Sử dụng ID của trạng thái mối quan hệ\n" +
            "    ))\n" +
            "    AND accounts.id <> :accountID\n" +
            "\tAND (genders.name like :genderName)\n" +
            "    AND (location.name like :locationName);",
            nativeQuery = true)
    List<IRecommendFriendDto> findAllRecommendFriend(@Param("accountID") Integer accountID,
                                                     @Param("genderName") String genderName,
                                                     @Param("locationName") String locationName);
//
//    @Query(value = "SELECT \n" +
//            "    location.name AS location,\n" +
//            "    jobs.name AS job,\n" +
//            "    hobbies.name AS hobby,\n" +
//            "    genders.name AS gender,\n" +
//            "    accounts.name AS name,\n" +
//            "    accounts.avatar AS avatar,\n" +
//            "    accounts.id AS id\n" +
//            "FROM \n" +
//            "    location\n" +
//            "LEFT JOIN \n" +
//            "    accounts ON accounts.location_id = location.id\n" +
//            "LEFT JOIN \n" +
//            "    jobs ON accounts.job_id = jobs.id\n" +
//            "LEFT JOIN \n" +
//            "    hobby_detail ON hobby_detail.account_id = accounts.id\n" +
//            "LEFT JOIN \n" +
//            "    hobbies ON hobby_detail.hobby_id = hobbies.id\n" +
//            "LEFT JOIN \n" +
//            "    genders ON accounts.gender_id = genders.id\n" +
//            "WHERE \n" +
//            "    (jobs.id = (\n" +
//            "        SELECT accounts.job_id\n" +
//            "        FROM accounts\n" +
//            "        WHERE accounts.id = :accountID\n" +
//            "    ) or\n" +
//            "    hobbies.id = (\n" +
//            "        SELECT hobby_detail.hobby_id\n" +
//            "        FROM hobby_detail\n" +
//            "        WHERE hobby_detail.account_id = :accountID\n" +
//            "    ) or \n" +
//            "    location.id = (\n" +
//            "        SELECT accounts.location_id\n" +
//            "        FROM accounts\n" +
//            "        WHERE accounts.id = :accountID\n" +
//            "    )\n" +
//            "    AND NOT EXISTS (\n" +
//            "        SELECT :accountID\n" +
//            "        FROM relationships r\n" +
//            "        WHERE \n" +
//            "            (r.sender_account_id = accounts.id AND r.receiver_account_id = :accountID)\n" +
//            "            OR (r.sender_account_id = :accountID AND r.receiver_account_id = accounts.id)\n" +
//            "            AND r.relationship_status_id IN (1, 2, 3) -- Sử dụng ID của trạng thái mối quan hệ\n" +
//            "    ))\n" +
//            "\tAND accounts.id <> :accountID\n" +
//            "    AND (genders.name like :genderName);",
//            nativeQuery = true)
//    List<IRecommendFriendDto> findAllRecommendFriend111(@Param("accountID") Integer accountID, @Param("genderName") String genderName);
////
//    /**
//     * method sortByLocation
//     * Create HungHLP
//     * Date 14-11-2023
//     * return list  recommend friend sort by location
//     */
//
//    @Query(value = "SELECT \n" +
//            "    location.name AS location,\n" +
//            "    jobs.name AS job,\n" +
//            "    hobbies.name AS hobby,\n" +
//            "    genders.name AS gender,\n" +
//            "    accounts.name AS name,\n" +
//            "    accounts.avatar AS avatar,\n" +
//            "    accounts.id AS id\n" +
//            "FROM \n" +
//            "    location\n" +
//            "LEFT JOIN \n" +
//            "    accounts ON accounts.location_id = location.id\n" +
//            "LEFT JOIN \n" +
//            "    jobs ON accounts.job_id = jobs.id\n" +
//            "LEFT JOIN \n" +
//            "    hobby_detail ON hobby_detail.account_id = accounts.id\n" +
//            "LEFT JOIN \n" +
//            "    hobbies ON hobby_detail.hobby_id = hobbies.id\n" +
//            "LEFT JOIN \n" +
//            "    genders ON accounts.gender_id = genders.id\n" +
//            "WHERE \n" +
//            "    location.id = (\n" +
//            "        SELECT accounts.location_id\n" +
//            "        FROM accounts\n" +
//            "        WHERE accounts.id = :accountID\n" +
//            "    )\n" +
//            "    AND NOT EXISTS (\n" +
//            "        SELECT :accountID\n" +
//            "        FROM relationships r\n" +
//            "        WHERE \n" +
//            "            (r.sender_account_id = accounts.id AND r.receiver_account_id = :accountID)\n" +
//            "            OR (r.sender_account_id = :accountID AND r.receiver_account_id = accounts.id)\n" +
//            "            AND r.relationship_status_id IN (1, 2, 3) -- Sử dụng ID của trạng thái mối quan hệ\n" +
//            "    )\n" +
//            "    AND accounts.id <> :accountID AND (genders.name like :genderName) AND (location.name like :locationName) -- Tránh trùng lặp với tài khoản đang đăng nhập;", nativeQuery = true)
//    List<IRecommendFriendDto> sortByLocation(@Param("accountID") int accountID,
//                                             @Param("genderName") String genderName,
//                                             @Param("locationName") String locationName);


    /**
     * method sortByHobby
     * Create HungHLP
     * Date 14-11-2023
     * return list  recommend friend sort by hobby
     */
    @Query(value = "SELECT \n" +
            "    location.name AS location,\n" +
            "    jobs.name AS job,\n" +
            "    hobbies.name AS hobby,\n" +
            "    genders.name AS gender,\n" +
            "    accounts.name AS name,\n" +
            "    accounts.avatar AS avatar,\n" +
            "    accounts.id AS id\n" +
            "FROM \n" +
            "    location\n" +
            "LEFT JOIN \n" +
            "    accounts ON accounts.location_id = location.id\n" +
            "LEFT JOIN \n" +
            "    jobs ON accounts.job_id = jobs.id\n" +
            "LEFT JOIN \n" +
            "    hobby_detail ON hobby_detail.account_id = accounts.id\n" +
            "LEFT JOIN \n" +
            "    hobbies ON hobby_detail.hobby_id = hobbies.id\n" +
            "LEFT JOIN \n" +
            "    genders ON accounts.gender_id = genders.id\n" +
            "WHERE \n" +
            "    hobbies.id = (\n" +
            "        SELECT hobby_detail.hobby_id\n" +
            "        FROM hobby_detail\n" +
            "        WHERE hobby_detail.account_id = :accountID\n" +
            "    )\n" +
            "    AND NOT EXISTS (\n" +
            "        SELECT :accountID\n" +
            "        FROM relationships r\n" +
            "        WHERE \n" +
            "            (r.sender_account_id = accounts.id AND r.receiver_account_id = :accountID)\n" +
            "            OR (r.sender_account_id = :accountID AND r.receiver_account_id = accounts.id)\n" +
            "            AND r.relationship_status_id IN (1, 2, 3) -- Sử dụng ID của trạng thái mối quan hệ\n" +
            "    )\n" +
            "    AND accounts.id <> :accountID AND (genders.name like :genderName) AND (location.name like :locationName)-- Tránh trùng lặp với tài khoản đang đăng nhập;", nativeQuery = true)
    List<IRecommendFriendDto> sortByHobby(@Param("accountID") int accountID,
                                          @Param("genderName") String genderName,
                                          @Param("locationName") String locationName);


    /**
     * method sortByJob
     * Create HungHLP
     * Date 14-11-2023
     * return list  recommend friend sort by job
     */
    @Query(value = "SELECT \n" +
            "    location.name AS location,\n" +
            "    jobs.name AS job,\n" +
            "    hobbies.name AS hobby,\n" +
            "    genders.name AS gender,\n" +
            "    accounts.name AS name,\n" +
            "    accounts.avatar AS avatar,\n" +
            "    accounts.id AS id\n" +
            "FROM \n" +
            "    location\n" +
            "LEFT JOIN \n" +
            "    accounts ON accounts.location_id = location.id\n" +
            "LEFT JOIN \n" +
            "    jobs ON accounts.job_id = jobs.id\n" +
            "LEFT JOIN \n" +
            "    hobby_detail ON hobby_detail.account_id = accounts.id\n" +
            "LEFT JOIN \n" +
            "    hobbies ON hobby_detail.hobby_id = hobbies.id\n" +
            "LEFT JOIN \n" +
            "    genders ON accounts.gender_id = genders.id\n" +
            "WHERE \n" +
            "    jobs.id = (\n" +
            "        SELECT accounts.job_id\n" +
            "        FROM accounts\n" +
            "        WHERE accounts.id = :accountID\n" +
            "    )\n" +
            "    AND NOT EXISTS (\n" +
            "        SELECT :accountID\n" +
            "        FROM relationships r\n" +
            "        WHERE \n" +
            "            (r.sender_account_id = accounts.id AND r.receiver_account_id = :accountID)\n" +
            "            OR (r.sender_account_id = :accountID AND r.receiver_account_id = accounts.id)\n" +
            "            AND r.relationship_status_id IN (1, 2, 3) -- Sử dụng ID của trạng thái mối quan hệ\n" +
            "    )\n" +
            "    AND accounts.id <> :accountID AND (genders.name like :genderName) AND (location.name like :locationName)-- Tránh trùng lặp với tài khoản đang đăng nhập;", nativeQuery = true)
    List<IRecommendFriendDto> sortByJob(@Param("accountID") int accountID,
                                        @Param("genderName") String genderName,
                                        @Param("locationName") String locationName);


}