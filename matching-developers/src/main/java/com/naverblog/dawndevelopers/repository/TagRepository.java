package com.naverblog.dawndevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naverblog.dawndevelopers.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
