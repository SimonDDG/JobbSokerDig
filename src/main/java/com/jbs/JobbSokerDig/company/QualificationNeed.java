package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.values.QualificationLevel;

import javax.persistence.*;

@Entity
@Table(name = "Qualificationneed")
public class QualificationNeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Qualificationneedid")
    Long QualificationNeedId;

    @OneToOne
    @JoinColumn(name = "Qualificationid")
    Qualification qualification;

//    @OneToOne
//    @JoinColumn(name = "Qualificationlevelid")
//    QualificationLevel qualificationLevel;

    @ManyToOne
    @JoinColumn(name = "Openpositionid")
    OpenPosition openPosition;

    public QualificationNeed() {
    }

    public QualificationNeed(Long qualificationNeedId, Qualification qualification, OpenPosition openPosition) {
        QualificationNeedId = qualificationNeedId;
        this.qualification = qualification;
        this.openPosition = openPosition;
    }

    public OpenPosition getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(OpenPosition openPosition) {
        this.openPosition = openPosition;
    }

    public Long getQualificationNeedId() {
        return QualificationNeedId;
    }

    public void setQualificationNeedId(Long qualificationNeedId) {
        QualificationNeedId = qualificationNeedId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

//    public QualificationLevel getQualificationLevel() {
//        return qualificationLevel;
//    }
//
//    public void setQualificationLevel(QualificationLevel qualificationLevel) {
//        this.qualificationLevel = qualificationLevel;
//    }

    }
