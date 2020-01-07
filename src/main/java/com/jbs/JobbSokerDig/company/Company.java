package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.general.Login;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Companyid")
    Long CompanyId;

    @OneToOne
    @JoinColumn(name = "LoginID")
    Login login;

    @Column(name = "Name")
    String Name;

    @Column(name = "email")
    String email;

    @Column(name = "Description")
    String Description;

    public Long getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(Long companyId) {
        CompanyId = companyId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
