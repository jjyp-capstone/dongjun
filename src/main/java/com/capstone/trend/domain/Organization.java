package com.capstone.trend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "organization_order")
public class Organization {

    @Id
    @Column(name = "organ_id")
    private Integer organ_id;

    @Column(name = "organization")
    private String organization;

    @Column(name = "patent_number")
    private Integer patent_number;

    @Column(name = "ipc_code")
    private String ipc_code;

    @Builder
    public Organization(Integer organ_id, String organization, Integer patent_number, String ipc_code){
        this.organ_id = organ_id;
        this.organization = organization;
        this.patent_number = patent_number;
        this.ipc_code =ipc_code;
    }

}
