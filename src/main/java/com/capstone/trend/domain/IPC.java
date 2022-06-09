package com.capstone.trend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@NoArgsConstructor
@Table(name = "test_table")
public class IPC {

    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "frequency")
    private Float frequency;
    @Column(name = "average_fluctuation_rate")
    private Float average_fluctuation_rate;

    @Builder
    public IPC(String code, Float frequency, Float average_fluctuation_rate){
        this.code = code;
        this.frequency = frequency;
        this.average_fluctuation_rate = average_fluctuation_rate;
    }

}
