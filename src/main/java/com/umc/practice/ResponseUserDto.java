package com.umc.practice;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ResponseUserDto {
    private final String nickname;
    private final String code;
    private final LocalDateTime joinDate;
    private final String phoneNumber;
    private final String fcmToken;
    private final Status status;

    public static ResponseUserDto of(UserEntity userEntity) {
        return ResponseUserDto.builder()
                .nickname(userEntity.getNickname())
                .code(userEntity.getCode())
                .joinDate(userEntity.getJoinDate())
                .phoneNumber(userEntity.getPhoneNumber())
                .fcmToken(userEntity.getFcmToken())
                .status(userEntity.getStatus())
                .build();
    }
}
