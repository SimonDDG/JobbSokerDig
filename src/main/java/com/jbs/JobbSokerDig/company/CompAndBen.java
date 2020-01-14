package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.values.Benefit;

import javax.persistence.*;

@Entity
@Table(name = "Compandben")
public class CompAndBen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Compandbenid")
    Long CompAndBenId;

    @OneToOne
    @JoinColumn(name = "Benefitid")
    Benefit benefit;

    @ManyToOne
    @JoinColumn(name = "Openpositionid")
    OpenPosition openPosition;

    public CompAndBen() {
    }

    public CompAndBen(Long compAndBenId, Benefit benefit, OpenPosition openPosition) {
        CompAndBenId = compAndBenId;
        this.benefit = benefit;
        this.openPosition = openPosition;
    }

    public OpenPosition getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(OpenPosition openPosition) {
        this.openPosition = openPosition;
    }

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


}
