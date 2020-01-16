package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.PreferanceLevel;

import javax.persistence.*;

@Entity
@Table(name = "Userpreference")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Userpreferenceid")
    private Long UserPreferenceId;

    @OneToOne
    @JoinColumn(name = "Benefitid")
    private Benefit benefit;

//    @OneToOne
//    @JoinColumn(name = "Preferencelevelid")
//    PreferanceLevel preferenceLevel;

    @ManyToOne
    @JoinColumn(name = "Usercandidateid")
    private UserCandidate userCandidate;

    @Column(name = "Musthave")
    private Boolean mustHave;

    public UserPreference() {
    }

    public UserPreference(Long userPreferenceId, Benefit benefit, /*PreferanceLevel preferenceLevel,*/ UserCandidate userCandidate, Boolean mustHave) {
        UserPreferenceId = userPreferenceId;
        this.benefit = benefit;
        //this.preferenceLevel = preferenceLevel;
        this.userCandidate = userCandidate;
        this.mustHave = mustHave;
    }

    public Boolean getMustHave() {
        return mustHave;
    }

    public void setMustHave(Boolean mustHave) {
        this.mustHave = mustHave;
    }

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

//    public PreferanceLevel getPreferenceLevel() {
//        return preferenceLevel;
//    }
//
//    public void setPreferenceLevel(PreferanceLevel preferenceLevel) {
//        this.preferenceLevel = preferenceLevel;
//    }

    public UserCandidate getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(UserCandidate userCandidate) {
        this.userCandidate = userCandidate;
    }
}
