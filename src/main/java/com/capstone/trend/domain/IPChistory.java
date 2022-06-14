package com.capstone.trend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ipc_history")
public class IPChistory {
    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "A01")
    private Integer A01;

    @Column(name = "A21")
    private Integer A11;

    @Column(name = "A22")
    private Integer A22;

    @Column(name = "A23")
    private Integer A23;

    @Column(name = "A24")
    private Integer A24;

    @Column(name = "A41")
    private Integer A41;

    @Column(name = "A42")
    private Integer A42;

    @Column(name = "A43")
    private Integer A43;

    @Column(name = "A44")
    private Integer A44;

    @Column(name = "A45")
    private Integer A45;

    @Column(name = "A46")
    private Integer A46;

    @Column(name = "A47")
    private Integer A47;

    @Column(name = "A61")
    private Integer A61;

    @Column(name = "A62")
    private Integer A62;

    @Column(name = "A63")
    private Integer A63;

    @Column(name = "B01")
    private Integer B01;

    @Column(name = "B02")
    private Integer B02;

    @Column(name = "B03")
    private Integer B03;

    @Column(name = "B04")
    private Integer B04;

    @Column(name = "B05")
    private Integer B05;

    @Column(name = "B06")
    private Integer B06;

    @Column(name = "B07")
    private Integer B07;

    @Column(name = "B08")
    private Integer B08;

    @Column(name = "B21")
    private Integer B21;

    @Column(name = "B22")
    private Integer B22;

    @Column(name = "B23")
    private Integer B23;

    @Column(name = "B24")
    private Integer B24;

    @Column(name = "B25")
    private Integer B25;

    @Column(name = "B26")
    private Integer B26;

    @Column(name = "B27")
    private Integer B27;

    @Column(name = "B28")
    private Integer B28;

    @Column(name = "B29")
    private Integer B29;

    @Column(name = "B30")
    private Integer B30;

    @Column(name = "B31")
    private Integer B31;

    @Column(name = "B32")
    private Integer B32;

    @Column(name = "B33")
    private Integer B33;

    @Column(name = "B41")
    private Integer B41;

    @Column(name = "B42")
    private Integer B42;

    @Column(name = "B43")
    private Integer B43;

    @Column(name = "B44")
    private Integer B44;

    @Column(name = "B60")
    private Integer B60;

    @Column(name = "B61")
    private Integer B61;

    @Column(name = "B62")
    private Integer B62;

    @Column(name = "B63")
    private Integer B63;

    @Column(name = "B64")
    private Integer B64;

    @Column(name = "B65")
    private Integer B65;

    @Column(name = "B66")
    private Integer B66;

    @Column(name = "B67")
    private Integer B67;

    @Column(name = "B81")
    private Integer B81;

    @Column(name = "B82")
    private Integer B82;

    @Column(name = "C01")
    private Integer C01;

    @Column(name = "C02")
    private Integer C02;

    @Column(name = "C03")
    private Integer C03;

    @Column(name = "C04")
    private Integer C04;

    @Column(name = "C05")
    private Integer C05;

    @Column(name = "C06")
    private Integer C06;

    @Column(name = "C07")
    private Integer C07;

    @Column(name = "C08")
    private Integer C08;

    @Column(name = "C09")
    private Integer C09;

    @Column(name = "C10")
    private Integer C10;

    @Column(name = "C11")
    private Integer C11;

    @Column(name = "C12")
    private Integer C12;

    @Column(name = "C13")
    private Integer C13;



}
