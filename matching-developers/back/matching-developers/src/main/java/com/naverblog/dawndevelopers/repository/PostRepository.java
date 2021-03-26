package com.naverblog.dawndevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naverblog.dawndevelopers.domain.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
