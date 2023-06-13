package com.umc.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getUsers() {
        List<ResponseUserDto> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody CreateRequestUserDto createRequestUserDto) {
        ResponseUserDto user = userService.signUp(createRequestUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable Long id) {
        ResponseUserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> editUser(
            @PathVariable Long id,
            @RequestBody EditRequestUserDto editRequestUserDto
    ) {
        ResponseUserDto user = userService.editUser(id, editRequestUserDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUserDto> removeUser(@PathVariable Long id) {
        ResponseUserDto user = userService.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
