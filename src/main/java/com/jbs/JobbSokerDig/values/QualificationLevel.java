package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Qualificationlevel")
public class QualificationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Qualificationlevelid")
    Long QualificationLevelId;

    @Column(name = "Qualificationlevel")
    int QualificationLevel;

    public Long getQualificationLevelId() {
        return QualificationLevelId;
    }

    public void setQualificationLevelId(Long qualificationLevelId) {
        QualificationLevelId = qualificationLevelId;
    }

    public int getQualificationLevel() {
        return QualificationLevel;
    }

    public void setQualificationLevel(int qualificationLevel) {
        QualificationLevel = qualificationLevel;
    }
}
