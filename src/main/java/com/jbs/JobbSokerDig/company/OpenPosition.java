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

    @Column(name = "Openpositiondescription")
    String OpenPositionDescription;

    public OpenPosition() {
    }

    public OpenPosition(Long openPositionId, Company company, String openPositionName, String openPositionDescription) {
        OpenPositionId = openPositionId;
        this.company = company;
        this.openPositionName = openPositionName;
        OpenPositionDescription = openPositionDescription;
    }

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

    public String getOpenPositionDescription() {
        return OpenPositionDescription;
    }

    public void setOpenPositionDescription(String openPositionDescription) {
        OpenPositionDescription = openPositionDescription;
    }
}
