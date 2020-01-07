package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.user.User;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.PreferanceLevel;

import javax.persistence.*;

@Entity
@Table(name = "UserPreferenceId")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserPreferenceId")
    Long UserPreferenceId;

    @OneToOne
    @JoinColumn(name = "BenefitId")
    Benefit benefit;

    @OneToOne
    @JoinColumn(name = "PreferenceLevelId")
    PreferanceLevel preferenceLevel;

    @ManyToOne
    @JoinColumn(name = "UserId")
    User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
