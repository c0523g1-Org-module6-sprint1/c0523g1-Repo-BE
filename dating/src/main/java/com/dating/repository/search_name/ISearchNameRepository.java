package com.dating.repository.search_name;

import com.dating.dto.search_name.SearchNameDto;
import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISearchNameRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT accounts.id, accounts.name, accounts.avatar, location.name, jobs.name \n" +
            "FROM accounts \n" +
            "            JOIN location ON accounts.location_id = location.id \n" +
            "            JOIN genders ON genders.id = accounts.gender_id \n" +
            "            JOIN jobs ON jobs.id = accounts.job_id\n" +
            "            WHERE accounts.name LIKE :name AND accounts.is_deleted = 0 LIMIT 20", nativeQuery = true)
    List<SearchNameDto> findAccountByName(String name);
}
