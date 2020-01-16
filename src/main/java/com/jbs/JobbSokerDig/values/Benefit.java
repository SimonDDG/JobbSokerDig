package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Benefit")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Benefitid")
    private Long BenefitId;

//    @OneToOne //Kolla på sen om det ska vara OneToMany
//    @JoinColumn(name = "Benefitspecificationid")
//    BenefitSpecification benefitSpecification;

    @Column(name = "Benefit")
    private String Benefit;

    public Long getBenefitId() {
        return BenefitId;
    }

    public void setBenefitId(Long benefitId) {
        BenefitId = benefitId;
    }

//    public BenefitSpecification getBenefitSpecification() {
//        return benefitSpecification;
//    }
//
//    public void setBenefitSpecification(BenefitSpecification benefitSpecification) {
//        this.benefitSpecification = benefitSpecification;
//    }

    public String getBenefit() {
        return Benefit;
    }

    public void setBenefit(String benefit) {
        Benefit = benefit;
    }
}
