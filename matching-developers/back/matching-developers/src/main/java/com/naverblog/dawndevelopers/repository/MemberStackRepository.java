package com.naverblog.dawndevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naverblog.dawndevelopers.domain.MemberStack;

public interface MemberStackRepository extends JpaRepository<MemberStack,Long> {
}
