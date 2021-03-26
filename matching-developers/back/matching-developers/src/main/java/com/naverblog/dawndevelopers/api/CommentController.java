package com.naverblog.dawndevelopers.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naverblog.dawndevelopers.api.dto.CommentRequestDto;
import com.naverblog.dawndevelopers.domain.Member;
import com.naverblog.dawndevelopers.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseTemplate<?> addComment(@PathVariable("id") Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        /*
            TODO : test Member
         */
        Long memberId = 1L;
        Long result = commentService.addComment(memberId, postId, commentRequestDto.toEntity());
        return new ResponseTemplate<>(result+"로 저장되었습니다.");
    }
}
