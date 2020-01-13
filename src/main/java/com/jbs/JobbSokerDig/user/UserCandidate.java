package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.general.Login;

import javax.persistence.*;

@Entity
@Table(name = "Usercandidate")
public class UserCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Usercandidateid")
    Long UserCandidateId;

    @OneToOne
    @JoinColumn(name = "Loginid")
    Login login;

    @Column(name = "Fullname")
    String fullName;

    @Column(name = "email")
    String email;

    @Column(name = "Description")
    String Description;

    @Column(name = "Experiencesandprojects")
    String ExperiencesAndProjects;

    Integer averagePercentageMatchedInRelationToOpenPosition;

    public Integer getAveragePercentageMatchedInRelationToOpenPosition() { return averagePercentageMatchedInRelationToOpenPosition; }

    public void setAveragePercentageMatchedInRelationToOpenPosition(Integer averagePercentageMatchedInRelationToOpenPosition) { this.averagePercentageMatchedInRelationToOpenPosition = averagePercentageMatchedInRelationToOpenPosition; }

    public Long getUserCandidateId() {
        return UserCandidateId;
    }

    public void setUserCandidateId(Long userCandidateId) {
        this.UserCandidateId = userCandidateId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getExperiencesAndProjects() {
        return ExperiencesAndProjects;
    }

    public void setExperiencesAndProjects(String experiencesAndProjects) {
        ExperiencesAndProjects = experiencesAndProjects;
    }
}
