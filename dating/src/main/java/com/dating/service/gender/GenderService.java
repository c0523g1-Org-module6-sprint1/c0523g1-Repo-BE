package com.dating.service.gender;

import com.dating.model.gender.Gender;
import com.dating.repository.gender.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {
    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public List<Gender> getAll() {
        return genderRepository.getAllBy();
    }
}
