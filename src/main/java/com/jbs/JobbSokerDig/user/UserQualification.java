package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.values.QualificationLevel;

import javax.persistence.*;

@Entity
@Table(name = "Userqualification")
public class UserQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Userqualificationid")
    Long UserQualificationId;

    @OneToOne
    @JoinColumn(name = "Qualificationid")
    Qualification userQualification;

    @OneToOne
    @JoinColumn(name = "Qualificationlevelid")
    QualificationLevel userQualificationLevel;

    @ManyToOne
    @JoinColumn(name = "Usercandidateid")
    UserCandidate userCandidate;

    public UserQualification() {
    }

    public UserQualification(Long userQualificationId, Qualification userQualification, QualificationLevel userQualificationLevel, UserCandidate userCandidate) {
        UserQualificationId = userQualificationId;
        this.userQualification = userQualification;
        this.userQualificationLevel = userQualificationLevel;
        this.userCandidate = userCandidate;
    }

    public Long getUserQualificationId() {
        return UserQualificationId;
    }

    public void setUserQualificationId(Long userQualificationId) {
        UserQualificationId = userQualificationId;
    }

    public Qualification getUserQualification() {
        return userQualification;
    }

    public void setUserQualification(Qualification userQualification) {
        this.userQualification = userQualification;
    }

    public QualificationLevel getUserQualificationLevel() {
        return userQualificationLevel;
    }

    public void setUserQualificationLevel(QualificationLevel userQualificationLevel) {
        this.userQualificationLevel = userQualificationLevel;
    }

    public UserCandidate getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(UserCandidate userCandidate) {
        this.userCandidate = userCandidate;
    }
}
