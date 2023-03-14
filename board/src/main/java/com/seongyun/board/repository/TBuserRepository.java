package com.seongyun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seongyun.board.entity.TBuserEntity;

@Repository
public interface TBuserRepository extends JpaRepository<TBuserEntity, String> {
    public boolean existsByTbUserEmailAndTbUserPwd(String UserEmail, String UserPwd);

    public TBuserEntity findByTbUserEmail(String UserEmail);
}
