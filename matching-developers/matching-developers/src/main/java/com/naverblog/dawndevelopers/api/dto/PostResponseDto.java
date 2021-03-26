package com.naverblog.dawndevelopers.api.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.naverblog.dawndevelopers.domain.Comment;
import com.naverblog.dawndevelopers.domain.Post;
import com.naverblog.dawndevelopers.domain.Tag;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private List<String> tags = new ArrayList<>();
    private List<CommentResponseDto> comments = new ArrayList<>();
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public PostResponseDto(Long id, String title, String content, List<String> tags, List<CommentResponseDto> comments, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.comments = comments;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    @Getter
    @Setter
    @ToString
    static class CommentResponseDto {
        private Long userId;
        private String contents;
        private LocalDateTime createDate;
        private LocalDateTime modifiedDate;

        @Builder
        CommentResponseDto(Long userId, String contents, LocalDateTime createDate, LocalDateTime modifiedDate) {
            this.userId = userId;
            this.contents = contents;
            this.createDate = createDate;
            this.modifiedDate = modifiedDate;
        }

        static CommentResponseDto from(Comment comment) {
            return builder()
                    .contents(comment.getContent())
                    .createDate(comment.getCreateTime())
                    .modifiedDate(comment.getModifiedTime())
                    .userId(123L)
                    .build();
        }
    }

    public static PostResponseDto getPostResponse(Post post) {
        return builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .tags(post.getTags().stream()
                          .map(Tag::getName).collect(Collectors.toList()))
                .createDate(post.getCreateTime())
                .modifiedDate(post.getModifiedTime())
                .comments(post.getComments().stream()
                              .map(CommentResponseDto::from)
                              .collect(Collectors.toList()))
                .build();
    }
}
