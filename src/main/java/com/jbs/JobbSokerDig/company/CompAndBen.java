package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.values.Benefit;

import javax.persistence.*;

@Entity
@Table(name = "CompAndBen")
public class CompAndBen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompAndBenId")
    Long CompAndBenId;

    @OneToOne
    @JoinColumn(name = "BenefitId")
    Benefit benefit;

    @ManyToOne
    @JoinColumn(name = "CompanyId")
    Company company;

    public Long getCompAndBenId() {
        return CompAndBenId;
    }

    public void setCompAndBenId(Long compAndBenId) {
        CompAndBenId = compAndBenId;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
