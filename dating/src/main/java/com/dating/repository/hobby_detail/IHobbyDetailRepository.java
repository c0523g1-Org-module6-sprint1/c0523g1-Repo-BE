package com.dating.repository.hobby_detail;

import com.dating.model.hobby.Hobby;
import com.dating.model.hobby_detail.HobbyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHobbyDetailRepository extends JpaRepository<HobbyDetail, Integer> {
    List<HobbyDetail> getAllBy();
}
