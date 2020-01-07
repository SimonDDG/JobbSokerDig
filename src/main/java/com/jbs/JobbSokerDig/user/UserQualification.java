package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.user.User;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.values.QualificationLevel;

import javax.persistence.*;

@Entity
@Table(name = "UserQualification")
public class UserQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserQualificationId")
    Long UserQualificationId;

    @OneToOne
    @JoinColumn(name = "QualificationId")
    Qualification qualification;

    @OneToOne
    @JoinColumn(name = "QualificationLevelId")
    QualificationLevel qualificationLevel;

    @ManyToOne
    @JoinColumn(name = "UserId")
    User user;

    public Long getUserQualificationId() {
        return UserQualificationId;
    }

    public void setUserQualificationId(Long userQualificationId) {
        UserQualificationId = userQualificationId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public QualificationLevel getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
