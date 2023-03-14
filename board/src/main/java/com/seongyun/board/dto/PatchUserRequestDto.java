package com.seongyun.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserRequestDto {
    private String tbUserNickname;
    private String tbUserProfile;
}
