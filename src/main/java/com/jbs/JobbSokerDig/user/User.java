package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.general.Login;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long UserId;

    @OneToOne
    @JoinColumn(name = "LoginID")
    Login login;

    @Column(name = "FullName")
    String fullName;

    @Column(name = "email")
    String email;

    @Column(name = "Description")
    String Description;

    @Column(name = "ExperiencesAndProjects")
    String ExperiencesAndProjects;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        this.UserId = userId;
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
