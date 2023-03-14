package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBboardEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface TBboardRepository extends JpaRepository<TBboardEntity, Integer> {
    public List<TBboardEntity> findTop3ByTbBoardCruserDateAfterOrderByTbBoardCruserCntlikeDesc(Date tbBoardCruserDate);
    public List<TBboardEntity> findByOrderByTbBoardCruserDateDesc();

    public List<TBboardEntity> findByTbBoardTitleContains(String tbBoardTitle);
}