package com.dating.service.post;

import com.dating.model.post.PrivacyPost;
import com.dating.repository.post.IPrivacyPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivacyPostService implements IPrivacyPostService{
    @Autowired
    private IPrivacyPostRepository iPrivacyPostRepository;

    @Override
    public List<PrivacyPost> showListPrivacyPost() {
        return iPrivacyPostRepository.showListPrivacyPost();
    }
}
