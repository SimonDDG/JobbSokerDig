package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.PreferanceLevel;

import javax.persistence.*;

@Entity
@Table(name = "Userpreferenceid")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Userpreferenceid")
    Long UserPreferenceId;

    @OneToOne
    @JoinColumn(name = "Benefitid")
    Benefit benefit;

    @OneToOne
    @JoinColumn(name = "Preferencelevelid")
    PreferanceLevel preferenceLevel;

    @ManyToOne
    @JoinColumn(name = "Usercandidateid")
    UserCandidate userCandidate;

    public Long getUserPreferenceId() {
        return UserPreferenceId;
    }

    public void setUserPreferenceId(Long userPreferenceId) {
        UserPreferenceId = userPreferenceId;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public PreferanceLevel getPreferenceLevel() {
        return preferenceLevel;
    }

    public void setPreferenceLevel(PreferanceLevel preferenceLevel) {
        this.preferenceLevel = preferenceLevel;
    }

    public UserCandidate getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(UserCandidate userCandidate) {
        this.userCandidate = userCandidate;
    }
}