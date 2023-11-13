package com.dating.service.post;

import com.dating.model.post.Post;
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
    public boolean create(LocalDateTime date, String content, String image, Integer accountId, Integer privacyId) {
        try {
            iPostRepository.create(date, content, image, accountId, privacyId);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public List<Post> showListPublic() {
        return iPostRepository.showListPublic();
    }

    @Override
    public List<Post> showListFriend() {
        return iPostRepository.showListFriend();
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
}
