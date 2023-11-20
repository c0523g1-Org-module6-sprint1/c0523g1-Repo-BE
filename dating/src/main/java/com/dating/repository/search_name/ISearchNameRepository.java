package com.dating.repository.search_name;

import com.dating.dto.search_name.MainPageDto;
import com.dating.dto.search_name.SearchNameDto;
import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISearchNameRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT accounts.id, accounts.name, accounts.avatar, location.name as location, jobs.name as job \n" +
            "FROM accounts \n" +
            "            JOIN location ON accounts.location_id = location.id \n" +
            "            JOIN genders ON genders.id = accounts.gender_id \n" +
            "            JOIN jobs ON jobs.id = accounts.job_id\n" +
            "            WHERE accounts.name LIKE :name AND accounts.is_deleted = 0 ORDER BY accounts.money DESC LIMIT 20", nativeQuery = true)
    List<SearchNameDto> findAccountByName(@Param("name")String name);
    @Query(value = "SELECT id, avatar, role_id as role FROM accounts WHERE user_name = :userName",nativeQuery = true)
    MainPageDto findByUserName (@Param("userName")String userName);
}
