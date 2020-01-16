package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Benefit")
public class BenefitSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Benefitspecificationid")
    private Long BenefitSpecificationId;

    @Column(name = "Benefitspec")
    private String BenefitSpec;

    public Long getBenefitSpecificationId() {
        return BenefitSpecificationId;
    }

    public void setBenefitSpecificationId(Long benefitSpecificationId) {
        BenefitSpecificationId = benefitSpecificationId;
    }

    public String getBenefitSpec() {
        return BenefitSpec;
    }

    public void setBenefitSpec(String benefitSpec) {
        BenefitSpec = benefitSpec;
    }
}
