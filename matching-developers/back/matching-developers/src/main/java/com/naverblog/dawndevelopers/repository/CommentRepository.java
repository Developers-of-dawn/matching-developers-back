package com.naverblog.dawndevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naverblog.dawndevelopers.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
