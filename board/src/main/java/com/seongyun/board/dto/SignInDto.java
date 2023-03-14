package com.seongyun.board.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userPwd;
}
