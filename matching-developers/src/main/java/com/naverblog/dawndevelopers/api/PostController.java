package com.naverblog.dawndevelopers.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naverblog.dawndevelopers.api.dto.PostResponseDto;
import com.naverblog.dawndevelopers.api.dto.PostSaveRequestDto;
import com.naverblog.dawndevelopers.domain.Member;
import com.naverblog.dawndevelopers.domain.Post;
import com.naverblog.dawndevelopers.domain.Tag;
import com.naverblog.dawndevelopers.service.MemberService;
import com.naverblog.dawndevelopers.service.PostService;
import com.naverblog.dawndevelopers.service.TagService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {
    private final MemberService memberService;
    private final PostService postService;
    private final TagService tagService;

    @GetMapping("/{id}")
    public ResponseTemplate<?> getPost(@PathVariable("id") Long id){
        PostResponseDto postResponse = postService.getPostResponse(id);
        return new ResponseTemplate<>(postResponse);
    }

    @PostMapping("/")
    public ResponseTemplate<?> addPost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        Member member = new Member();
        memberService.save(member);
        log.info("save Post: {}", postSaveRequestDto);
        Post post = postSaveRequestDto.toPost();
        List<Tag> tags = postSaveRequestDto.toTags();
        log.info("tags: {}", tags);
        Long save = postService.save(member, post, tags);
        return new ResponseTemplate<>(save + "로 저장되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseTemplate<?> deletePost(@PathVariable("id") Long id) {
        Long deletedId = postService.deleteById(id);
        return new ResponseTemplate<>(deletedId + "번 글이 삭제되었습니다.");
    }

}
