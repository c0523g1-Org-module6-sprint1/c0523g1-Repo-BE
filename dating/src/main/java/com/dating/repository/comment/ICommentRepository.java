package com.dating.repository.comment;

import com.dating.model.comment.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;

public interface ICommentRepository extends JpaRepository<Comments,Integer> {

}
