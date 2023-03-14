package com.seongyun.board.controller;

import com.seongyun.board.dto.ResponseDto;
import com.seongyun.board.entity.TBboardEntity;
import com.seongyun.board.entity.TBpopularsearchEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
//    @GetMapping("/")
//    public String getBoard(@AuthenticationPrincipal String tbUserEmail) {
//        return "로그인된 사용자는 " + tbUserEmail + " 입니다.";
//    }

    @GetMapping("/top3")
    public ResponseDto<List<TBboardEntity>> getTop3() {
       return null;
    }

    @GetMapping("/list")
    public ResponseDto<List<TBboardEntity>> getList() {
        return null;
    }

    @GetMapping("/popularsearchEntity")
    public  ResponseDto<List<TBpopularsearchEntity>> getPopularsearchList() {
        return null;
    }
}
