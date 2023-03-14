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
    private String tbBoardTitle;
    private String tbBoardContent;
    private String tbBoardImage;
    private String tbBoardVideo;
    private String tbBoardFile;
    private String tbBoardCruserEmail;
    private String tbBoardCruserProfile;
    private String tbBoardCruserNickname;
    private String tbBoardCruserDate;
    private String tbBoardCruserCntclick;
    private String tbBoardCruserCntlike;
    private String tbBoardCruserCntcomment;
}
