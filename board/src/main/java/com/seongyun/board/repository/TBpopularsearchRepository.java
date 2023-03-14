package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBpopularsearchEntity;
import java.util.List;
@Repository
public interface TBpopularsearchRepository extends JpaRepository<TBpopularsearchEntity, String> {

    public List<TBpopularsearchEntity> findTop10ByOrderByTbPopularsearchCountDesc();
}
