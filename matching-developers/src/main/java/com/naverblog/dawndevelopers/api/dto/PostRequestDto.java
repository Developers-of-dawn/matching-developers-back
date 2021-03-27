package com.naverblog.dawndevelopers.api.dto;

import com.naverblog.dawndevelopers.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String content;

    @Builder
    public PostRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                   .title(getTitle())
                   .content(getContent())
                   .build();
    }
}
