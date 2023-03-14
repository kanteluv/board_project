package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBpopularsearchEntity;

@Repository
public interface TBpopularsearchRepository extends JpaRepository<TBpopularsearchEntity, String> {
}
