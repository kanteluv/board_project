package com.seongyun.board.controller;

import com.seongyun.board.dto.ResponseDto;
import com.seongyun.board.dto.SignInDto;
import com.seongyun.board.dto.SignInResponseDto;
import com.seongyun.board.dto.SignUpDto;
//import com.seongyun.board.dto.SignUpResponseDto;
import com.seongyun.board.service.AuthService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired AuthService authService;
    @PostMapping("/signUp")
    public ResponseDto<?> SignUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> SignIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> result = authService.SignIn(requestBody);
        return  result;
    }
}
