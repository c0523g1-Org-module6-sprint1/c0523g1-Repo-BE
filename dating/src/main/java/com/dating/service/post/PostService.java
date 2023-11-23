package com.dating.service.post;

import com.dating.model.post.Post;
import com.dating.model.relationship.Relationships;
import com.dating.repository.post.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public boolean create(String content, String image, Integer accountId, Integer privacyId) {
        try {
            iPostRepository.create(content, image, accountId, privacyId);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public List<Post> showListNewsfeed(Integer loggedInAccountId) {
        return iPostRepository.showListNewsfeed(loggedInAccountId);
    }

    @Override
    public List<Post> showListOfAnAccount(Integer accountId) {
        return iPostRepository.showListOfAnAccount(accountId);
    }

    @Override
    public Post getPostById(Integer id) {
        Post post = iPostRepository.getPostById(id);
        if (post != null) {
            return post;
        }
        return null;
    }

    @Override
    public boolean updateForThePostOwner(String content, String image, Integer accountId,
                                         Integer postId, Integer privacyPostId) {
        try {
            iPostRepository.updateForThePostOwner(content, image, accountId, postId, privacyPostId);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateForAdmin(String content, String image, Integer postId, Integer privacyPostId) {
        try {
            iPostRepository.updateForAdmin(content, image, postId, privacyPostId);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteForAdmin(Integer id) {
        try {
            iPostRepository.deleteForAdmin(id);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteForThePostOwner(Integer id, Integer accountId) {
        try {
            iPostRepository.deleteForThePostOwner(id, accountId);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public List<Post> showListForAdmin() {
        return iPostRepository.showListForAdmin();
    }

    @Override
    public Boolean checkIsFriend(Integer accountId1, Integer accountId2) {
        Integer record = iPostRepository.checkIsFriend(accountId1, accountId2);
        if (record == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Post> getListForFriend(Integer accountId) {
        return iPostRepository.getListForFriend(accountId);
    }

    @Override
    public List<Post> getListForStranger(Integer accountId) {
        return iPostRepository.getListForStranger(accountId);
    }
}
