package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.user.UserCandidate;

import javax.persistence.*;

@Entity
@Table(name = "Softoffer")
public class SoftOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Softofferid")
    private Long SoftOfferId;

    @ManyToOne
    @JoinColumn(name = "Usercandidateid")
    private UserCandidate userCandidate;

    @ManyToOne
    @JoinColumn(name = "Companyid")
    private Company company;

    @Column(name = "Softoffer")
    private String SoftOffer;

    @Column(name = "Userstatus")
    private String UserStatus;

    @ManyToOne
    @JoinColumn(name = "Openpositionid")
    private OpenPosition openPosition;

    public Long getSoftOfferId() {
        return SoftOfferId;
    }

    public void setSoftOfferId(Long softOfferId) {
        SoftOfferId = softOfferId;
    }

    public UserCandidate getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(UserCandidate userCandidate) {
        this.userCandidate = userCandidate;
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

    public String getUserStatus() {
        return UserStatus;
    }

    public void setUserStatus(String userStatus) {
        UserStatus = userStatus;
    }

    public OpenPosition getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(OpenPosition openPosition) {
        this.openPosition = openPosition;
    }
}
