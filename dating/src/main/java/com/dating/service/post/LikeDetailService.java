package com.dating.service.post;

import com.dating.repository.post.ILikeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeDetailService implements ILikeDetailService {
    @Autowired
    private ILikeDetailRepository iLikeDetailRepository;

    @Override
    public void insertLikeDetail(Integer accountId, Integer postId) {
        iLikeDetailRepository.insertLikeDetail(accountId, postId);
    }

    @Override
    public void deleteLike(Integer postId, Integer accountId) {
        iLikeDetailRepository.deleteLike(postId,accountId);
    }

    @Override
    public Integer getAmountLikeOfPost(Integer postId) {
        return iLikeDetailRepository.getAmountLikeOfPost(postId);
    }

    @Override
    public Boolean checkIsLiked(Integer postId, Integer accountId) {
        Integer amount = iLikeDetailRepository.getAmountLikeOfPostOfAccount(postId, accountId);
        if (amount == 1) {
            return true;
        } else {
            return false;
        }
    }
}