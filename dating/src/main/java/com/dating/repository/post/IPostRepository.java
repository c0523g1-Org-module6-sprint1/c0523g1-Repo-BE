package com.dating.repository.post;

import com.dating.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Integer> {

}
