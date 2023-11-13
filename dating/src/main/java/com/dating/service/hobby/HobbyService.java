package com.dating.service.hobby;

import com.dating.model.hobby.Hobby;
import com.dating.repository.hobby.IHobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService implements IHobbyService {
    @Autowired
    private IHobbyRepository hobbyRepository;
    @Override
    public List<Hobby> getAll() {
        return hobbyRepository.getAllBy();
    }
}
