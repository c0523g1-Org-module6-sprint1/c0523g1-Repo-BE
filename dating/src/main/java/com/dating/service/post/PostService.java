package com.dating.service.post;

import com.dating.repository.post.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService implements IPostService{
    @Autowired
    private IPostRepository iPostRepository;
    @Override
    public void create(LocalDateTime date, String content, String image, Integer accountId, Integer privacyId) {
        iPostRepository.create(date,content,image,accountId,privacyId);
    }
}
