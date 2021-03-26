package com.naverblog.dawndevelopers.api.dto;

import com.naverblog.dawndevelopers.domain.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;

    @Builder
    public CommentRequestDto(String content) {
        this.content = content;
    }

    public Comment toEntity(){
        return Comment.builder()
                .content(getContent())
                .build();

    }
}
