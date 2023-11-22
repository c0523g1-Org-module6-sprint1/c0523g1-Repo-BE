package com.dating.repository.search_advanced_top_100;

import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.dto.top_100.TopHunderedDto;
import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAccountsRepository extends JpaRepository<Account, Integer> {
    @Transactional
    @Query(value = "SELECT accounts.id as id, accounts.name as name, location.name as location, jobs.name as job, accounts.avatar as avatar " +
            "FROM accounts " +
            "JOIN location ON accounts.location_id = location.id " +
            "JOIN genders ON genders.id = accounts.gender_id " +
            "JOIN jobs ON jobs.id = accounts.job_id " +
            "left JOIN hobby_detail ON hobby_detail.account_id = accounts.id " +
            "left JOIN hobbies ON hobbies.id = hobby_detail.hobby_id " +
            "WHERE accounts.name like :name " +
            "and genders.id = :genderId " +
            "and ((YEAR(CURRENT_DATE()) - YEAR(accounts.birthday) BETWEEN :birthdayFrom AND :birthdayEnd) " +
            "and jobs.id = :jobId " +
            "and location.code = :locationId " +
            "and hobbies.id = :hobbyDetailId) ",
            nativeQuery = true)
    List<SearchAvancedDto> findAll(@Param("name") String name, @Param("birthdayFrom") int birthdayFrom, @Param("birthdayEnd")
    int birthdayEnd, @Param("genderId") int genderId, @Param("locationId") int locationId, @Param("jobId") int jobId,
                                   @Param("hobbyDetailId") int hobbyDetailId);


    @Transactional
    @Query(value = "SELECT accounts.id, accounts.avatar, accounts.name, account_types.name as accountTypes, accounts.money as money, count(like_detail.id) AS countLike " +
            " FROM accounts " +
            " left JOIN package_detail ON accounts.id = package_detail.account_id " +
            " left JOIN account_types ON package_detail.account_types_id = account_types.id " +
            " left JOIN like_detail ON like_detail.account_id = accounts.id " +
            " GROUP BY accounts.id, accounts.avatar, accounts.name, account_types.name, accounts.money " +
            " ORDER BY countLike DESC " +
            " LIMIT 100 ",
            nativeQuery = true)
    List<TopHunderedDto> findAllByAccount();
}
