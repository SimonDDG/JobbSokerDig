package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Softoffer")
public class SoftOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SoftOfferid")
    Long SoftOfferId;

    @ManyToOne
    @JoinColumn(name = "Userid")
    User user;

    @ManyToOne
    @JoinColumn(name = "Companyid")
    Company company;

    @Column(name = "Softoffer")
    String SoftOffer;

    public Long getSoftOfferId() {
        return SoftOfferId;
    }

    public void setSoftOfferId(Long softOfferId) {
        SoftOfferId = softOfferId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSoftOffer() {
        return SoftOffer;
    }

    public void setSoftOffer(String softOffer) {
        SoftOffer = softOffer;
    }
}
