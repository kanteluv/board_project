package com.seongyun.board.controller;

import com.seongyun.board.dto.PatchUserRequestDto;
import com.seongyun.board.dto.PatchUserResponseDto;
import com.seongyun.board.dto.ResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @PatchMapping("/")
    public ResponseDto<PatchUserResponseDto> patchUser (@RequestBody PatchUserRequestDto requsetBody, @AuthenticationPrincipal String userEmail) {
        return null;
    }
}
