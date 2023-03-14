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
@Entity(name = "TB_BOARD")
@Table(name = "TB_BOARD")
public class TBboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNum;
    private String boardTitle;
    private String boardContent;
    private String boardImage;
    private String boardVideo;
    private String boardFile;
    private String boardCruserEmail;
    private String boardCruserProfile;
    private String boardCruserNickname;
    private String boardCruserDate;
    private String boardCruserCntclick;
    private String boardCruserCntlike;
    private String boardCruserCntcomment;
}
