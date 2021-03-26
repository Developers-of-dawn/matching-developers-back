package com.naverblog.dawndevelopers.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naverblog.dawndevelopers.domain.Tag;
import com.naverblog.dawndevelopers.repository.TagRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TagService {
    private final TagRepository tagRepository;

    @Transactional
    public Long save(List<Tag> tags){
        Stream<Tag> tagStream = tags.stream()
                                    .map(tagRepository::save);

        return tagStream.count();
    }

    @Transactional
    public Long delete(Long deleteId){
        tagRepository.deleteById(deleteId);
        return deleteId;
    }
}
