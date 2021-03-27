package com.naverblog.dawndevelopers.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naverblog.dawndevelopers.domain.Comment;
import com.naverblog.dawndevelopers.domain.Member;
import com.naverblog.dawndevelopers.domain.Post;
import com.naverblog.dawndevelopers.repository.CommentRepository;
import com.naverblog.dawndevelopers.repository.MemberRepository;
import com.naverblog.dawndevelopers.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long addComment(Long memberId, Long postId, Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        Optional<Post> post = postRepository.findById(postId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (member.isPresent() && post.isPresent()) {
            savedComment.addComment(member.get(), post.get());
            return savedComment.getId();
        }

        throw new IllegalStateException("문제가 발생했습니다.");
    }
}
