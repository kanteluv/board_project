package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBcommentEntity;

@Repository
public interface TBcommentRepository extends JpaRepository<TBcommentEntity, Integer> {
}
