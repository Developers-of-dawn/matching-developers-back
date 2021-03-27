package com.naverblog.dawndevelopers.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userId;
    private String password;
    private String email;
    private String nickname;
    private String phone;
    private String job;
    private String address;

    @OneToMany(mappedBy = "member")
    private Set<MemberStack> stacks = new HashSet<>();

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Member(String userId, String password, String email, String nickname, String phone, String job, String address) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.job = job;
        this.address = address;
    }

    public void addPost(Post post){
        this.posts.add(post);
        post.setMember(this);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setMember(this);
    }
}
