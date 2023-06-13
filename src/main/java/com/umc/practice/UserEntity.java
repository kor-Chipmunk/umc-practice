package com.umc.practice;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 12, nullable = false)
    private String nickname;

    @NotNull
    @Column(length = 24, nullable = false)
    private String code;

    @Column
    private LocalDateTime joinDate;

    @NotNull
    @Column(length = 24, nullable = false)
    private String phoneNumber;

    @Column
    private String fcmToken;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
}
