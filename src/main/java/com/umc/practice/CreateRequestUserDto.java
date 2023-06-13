package com.umc.practice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class CreateRequestUserDto {
    private String nickname;
    private String phoneNumber;
}
