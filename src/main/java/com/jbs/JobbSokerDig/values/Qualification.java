package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Qualificationid")
    Long QualificationId;

    @Column(name = "Qualification")
    String Qualification;

    public Long getQualificationId() {
        return QualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        QualificationId = qualificationId;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }
}
