package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Benefit")
public class BenefitSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long BenefitSpecificationId;

    @Column(name = "BenefitSpec")
    String BenefitSpec;

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
