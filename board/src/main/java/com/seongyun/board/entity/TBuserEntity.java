package com.seongyun.board.entity;

import com.seongyun.board.dto.SignUpDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="TB_USER")
@Table(name="TB_USER")
public class TBuserEntity {
    @Id
    private String tbUserEmail;
    private String tbUserPwd;
    private String tbUserNickname;
    private String tbUserHp;
    private String tbUserAddr;
    private String tbUserProfile;

    public TBuserEntity(SignUpDto dto) {
        this.tbUserEmail = dto.getUserEmail();
        this.tbUserPwd = dto.getUserPwd();
        this.tbUserNickname = dto.getUserNickname();
        this.tbUserHp = dto.getUserHp();
        this.tbUserAddr = dto.getUserAddr() + " " + dto.getUserAddrDetail();
        this.tbUserProfile = dto.getUserProfile();
    }
}
