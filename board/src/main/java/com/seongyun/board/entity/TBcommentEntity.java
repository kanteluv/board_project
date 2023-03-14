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
@Entity(name = "TB_COMMENT")
@Table(name = "TB_COMMENT")
public class TBcommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private int commentBoardnum;
    private String commentCruseremail;
    private String commentCruserprofile;
    private String commentCrusernickname;
    private String commentDate;
    private String commentContent;
}
