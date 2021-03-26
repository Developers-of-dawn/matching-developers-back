package com.naverblog.dawndevelopers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naverblog.dawndevelopers.api.dto.PostResponseDto;
import com.naverblog.dawndevelopers.domain.Member;
import com.naverblog.dawndevelopers.domain.Post;
import com.naverblog.dawndevelopers.domain.Tag;
import com.naverblog.dawndevelopers.repository.PostRepository;
import com.naverblog.dawndevelopers.repository.TagRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Transactional
    public Long save(Member member, Post post, List<Tag> tags) {
        Post savedPost = postRepository.save(post);
        member.addPost(savedPost);
        tags.forEach(tag ->{
            tagRepository.save(tag);
            post.addTags(tag);
        });
        return savedPost.getId();
    }

    @Transactional
    public Long deleteById(Long deleteId) {
        postRepository.deleteById(deleteId);
        return deleteId;
    }

    @Transactional
    public void update(){

    }

    public PostResponseDto getPostResponse(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.map(PostResponseDto::getPostResponse).orElse(null);
    }
}
