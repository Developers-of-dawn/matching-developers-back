package com.naverblog.dawndevelopers.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.naverblog.dawndevelopers.domain.Post;
import com.naverblog.dawndevelopers.domain.Tag;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostSaveRequestDto {
    private String title;
    private String content;
    private List<String> tags;

    @Builder
    public PostSaveRequestDto(String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public Post toPost() {
        return Post.builder()
                   .title(getTitle())
                   .content(getContent())
                   .build();
    }

    public List<Tag> toTags() {
        return tags.stream()
                   .map(s -> Tag.builder()
                                .name(s)
                                .build()
                   ).collect(Collectors.toList());
    }
}
