package com.example.demo.controller;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.dto.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserCreateDTO dto) {
        User userSaved = userService.saveUser(UserMapper.toDto(dto));
        return ResponseEntity.ok(UserMapper.toUser(userSaved));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> routeAdmin(Authentication authentication) {
        log.info(authentication.getName());
        return ResponseEntity.ok(String.format("Rota admin ok! Via user: %s", authentication.getName()));
    }
}
