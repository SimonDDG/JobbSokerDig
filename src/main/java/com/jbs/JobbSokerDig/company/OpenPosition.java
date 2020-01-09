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

    @OneToOne
    @JoinColumn(name = "Compandbenid")
    CompAndBen compAndBen;

    @OneToOne
    @JoinColumn(name = "Qualificationneedid")
    QualificationNeed qualificationNeed;

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

    public CompAndBen getCompAndBen() {
        return compAndBen;
    }

    public void setCompAndBen(CompAndBen compAndBen) {
        this.compAndBen = compAndBen;
    }

    public QualificationNeed getQualificationNeed() {
        return qualificationNeed;
    }

    public void setQualificationNeed(QualificationNeed qualificationNeed) {
        this.qualificationNeed = qualificationNeed;
    }

    public String getOpenPositionName() {
        return openPositionName;
    }

    public void setOpenPositionName(String openPositionName) {
        this.openPositionName = openPositionName;
    }
}
