package com.naverblog.dawndevelopers.api.dto;

import java.util.Optional;

import com.naverblog.dawndevelopers.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponseDto {
    private String nickname;

    public static MemberResponseDto of(Optional<Member> findMember) {
        return new MemberResponseDto(findMember.map(Member::getNickname).orElse("Empty"));
    }
}
