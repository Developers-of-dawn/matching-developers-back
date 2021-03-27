package com.naverblog.dawndevelopers.service;

import org.springframework.stereotype.Service;

import com.naverblog.dawndevelopers.domain.TechStack;
import com.naverblog.dawndevelopers.repository.StackRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StackService {
    private final StackRepository stackRepository;

    public Long save(String name){
        final TechStack techStack = new TechStack(name);
        return stackRepository.save(techStack).getId();
    }

    public Long delete(Long id) {
        stackRepository.deleteById(id);
        return id;
    }
}
