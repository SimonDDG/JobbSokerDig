package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.general.Login;

import javax.persistence.*;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long CompanyId;

    @OneToOne
    @JoinColumn(name = "LoginID")
    Login login;

    @Column(name = "Name")
    String Name;

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
}
