package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "QualificationLevel")
public class QualificationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QualificationLevelId")
    Long QualificationLevelId;

    @Column(name = "QualificationLevel")
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
