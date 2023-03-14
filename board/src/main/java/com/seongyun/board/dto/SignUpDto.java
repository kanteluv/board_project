package com.seongyun.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String userEmail;
    private String userPwd;
    private String userPwdChk;
    private String userNickname;
    private String userHp;
    private String userAddr;
    private String userAddrDetail;
    private String userProfile;
}
