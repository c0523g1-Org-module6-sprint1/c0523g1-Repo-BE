package com.dating.repository.search_advanced_top_100;

import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.dto.top_100.TopHunderedDto;
import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAccountsRepository extends JpaRepository<Account, Integer> {
//    @Transactional
//    @Query(value = " SELECT accounts.id, accounts.name, location.name as location , jobs.name as job , accounts.avatar  " +
//            " FROM accounts " +
//            " JOIN location ON accounts.location_id = location.id  " +
//            " JOIN genders ON genders.id = accounts.gender_id " +
//            " JOIN jobs ON jobs.id = accounts.job_id " +
//            " JOIN hobby_detail on hobby_detail.account_id = accounts.id " +
//            " JOIN hobbies ON hobby_detail.hobby_id = hobbies.id " +
//            " WHERE accounts.name LIKE :name AND genders.id = id AND accounts.birthday LIKE :birthday AND jobs.id = id AND location.id =id  AND hobbies.id = id",
//            nativeQuery = true)
//    List<SearchAvancedDto> findAll(String name, String birthday, int genderId, int hobbyId, int locationId, int jobId, int hobbyDetailId);

    @Transactional
    @Query(value = "SELECT accounts.id, accounts.avatar, accounts.name, account_types.name as account_type, accounts.money, count(like_detail.id) AS count_like " +
            " FROM accounts " +
            " JOIN package_detail ON accounts.id = package_detail.account_id " +
            " JOIN account_types ON package_detail.account_type_id = account_types.id " +
            " JOIN like_detail ON like_detail.account_id = accounts.id " +
            " GROUP BY accounts.id, accounts.avatar, accounts.name, account_types.name, accounts.money " +
            " ORDER BY count_like DESC " +
            " LIMIT 100 ",
            nativeQuery = true)
    List<TopHunderedDto> findAllByAccount();
}
