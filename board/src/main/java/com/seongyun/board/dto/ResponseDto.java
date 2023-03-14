package com.seongyun.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        //return new ResponseDto(true, message, data);
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFail(String message) {
        //return new ResponseDto(false, message, null);
        return ResponseDto.set(false, message, null);
    }
}
