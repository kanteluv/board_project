package com.seongyun.board.service;

import com.seongyun.board.dto.PatchUserRequestDto;
import com.seongyun.board.dto.ResponseDto;
import com.seongyun.board.entity.TBboardEntity;
import com.seongyun.board.entity.TBpopularsearchEntity;
import com.seongyun.board.repository.TBboardRepository;
import com.seongyun.board.repository.TBpopularsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {
    @Autowired TBboardRepository tBboardRepository;
    @Autowired TBpopularsearchRepository tBpopularsearchRepository;

    public ResponseDto<List<TBboardEntity>> getTop3 () {
//        Date date = new Date();
//        date.setDate(date.getDate() - 7);

        List<TBboardEntity> boardList = new ArrayList<TBboardEntity>();

        Date date = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));

        try {
            boardList = tBboardRepository.findTop3ByTbBoardCruserDateAfterOrderByTbBoardCruserCntlikeDesc(date);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();;
            return ResponseDto.setFail("DataBase Error");
        }
        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<TBboardEntity>> getList() {
        List<TBboardEntity> boardList = new ArrayList<TBboardEntity>();
        try {
            boardList = tBboardRepository.findByOrderByTbBoardCruserDateDesc();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();;
            return ResponseDto.setFail("DataBase Error");
        }
        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<TBpopularsearchEntity>> getPopularsearchList() {
        List<TBpopularsearchEntity> popularsearchList = new ArrayList<TBpopularsearchEntity>();

        try {
            popularsearchList = tBpopularsearchRepository.findTop10ByOrderByTbPopularsearchCountDesc();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseDto.setFail("DataBase Error");
        }

        return ResponseDto.setSuccess("Success", popularsearchList);
    }

    public ResponseDto<List<TBboardEntity>> getSearchList(String boardTitle) {
        List<TBboardEntity> boardList = new ArrayList<TBboardEntity>();
        try {
            boardList = tBboardRepository.findByTbBoardTitleContains(boardTitle);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseDto.setFail("DataBase Error");
        }

        return ResponseDto.setSuccess("Success", boardList);
    }
}
