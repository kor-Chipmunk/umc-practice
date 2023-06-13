package com.umc.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<ResponseUserDto> getUsers() {
        List<UserEntity> userList = userRepository.findByStatus(Status.ACTIVE);
        List<ResponseUserDto> responseUserList = userList.stream().map(
                user -> ResponseUserDto.of(user)
        ).collect(Collectors.toList());
        return responseUserList;
    }

    public ResponseUserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id).get();
        return ResponseUserDto.of(user);
    }

    public ResponseUserDto signUp(CreateRequestUserDto createRequestUserDto) {
        String randomCode = RandomCodeGenerator.getRandomCode();

        UserEntity userEntity = UserEntity.builder()
                .nickname(createRequestUserDto.getNickname())
                .code(randomCode)
                .phoneNumber(createRequestUserDto.getPhoneNumber())
                .status(Status.ACTIVE)
                .joinDate(LocalDateTime.now())
                .build();

        userRepository.save(userEntity);

        return ResponseUserDto.of(userEntity);
    }

    @Transactional
    public ResponseUserDto editUser(Long id, EditRequestUserDto editRequestUserDto) {
        UserEntity user = userRepository.findById(id).get();

        user.setNickname(editRequestUserDto.getNickname());
        userRepository.save(user);

        return ResponseUserDto.of(user);
    }

    @Transactional
    public ResponseUserDto deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();

        user.setStatus(Status.INACTIVE);
        userRepository.save(user);

        return ResponseUserDto.of(user);
    }

}
