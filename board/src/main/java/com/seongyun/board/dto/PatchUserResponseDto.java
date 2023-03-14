package com.seongyun.board.dto;

import com.seongyun.board.entity.TBuserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserResponseDto {

    private TBuserEntity user;
}
