package com.dating.service.hobby_detail;

import com.dating.model.hobby_detail.HobbyDetail;
import com.dating.repository.hobby_detail.IHobbyDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyDetailServcie implements IHobbyDetailService{
    private IHobbyDetailRepository hobbyDetailRepository;

    @Override
    public List<HobbyDetail> getAll() {
        return hobbyDetailRepository.getAllBy();
    }
}
