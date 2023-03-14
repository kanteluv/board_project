package com.seongyun.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_LIKE")
@Table(name = "TB_LIKE")
public class TBlikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    private int likeBoardnum;
    private String likeEmail;
    private String likeCruserProfile;
    private String likeCruserNickname;
}
