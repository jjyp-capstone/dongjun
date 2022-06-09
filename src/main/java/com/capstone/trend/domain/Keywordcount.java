package com.capstone.trend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.PublicKey;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "keyword_count")
public class Keywordcount {
    @Id
    @Column
    private String keyword;

    @Column
    private String ipc_code;

    @Column
    private Integer count;

    @Column
    private Integer rank;

    @Builder
    public Keywordcount(String keyword, String ipc_code, Integer count, Integer rank){
        this.keyword = keyword;
        this.ipc_code = ipc_code;
        this.count = count;
        this.rank = rank;
    }

}
