package com.jbs.JobbSokerDig.company;

import javax.persistence.*;

@Entity
@Table(name = "Openposition")
public class OpenPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Openpositionid")
    Long OpenPositionId;

    @ManyToOne
    @JoinColumn(name = "Companyid")
    Company company;


    @Column(name = "Openpositionname")
    String openPositionName;

    public Long getOpenPositionId() {
        return OpenPositionId;
    }

    public void setOpenPositionId(Long openPositionId) {
        OpenPositionId = openPositionId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public String getOpenPositionName() {
        return openPositionName;
    }

    public void setOpenPositionName(String openPositionName) {
        this.openPositionName = openPositionName;
    }
}
