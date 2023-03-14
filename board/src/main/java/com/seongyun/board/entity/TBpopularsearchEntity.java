package com.seongyun.board.entity;

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
@Entity(name = "TB_POPULARSEARCH")
@Table(name = "TB_POPULARSEARCH")
public class TBpopularsearchEntity {
    @Id
    private String tbPopularsearchTerm;
    private int tbPopularsearchCount;
}
