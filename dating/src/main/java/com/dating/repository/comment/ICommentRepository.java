package com.dating.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {

}
