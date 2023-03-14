package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBlikeEntity;

@Repository
public interface TBlikeRepository extends JpaRepository<TBlikeEntity, Integer> {
}