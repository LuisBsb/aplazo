package com.aplazo.repository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INTEREST")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "terms")
    private Integer terms;

    @OneToMany(mappedBy="interest", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InterestResponseRep> interestResponse = new HashSet<InterestResponseRep>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public Set<InterestResponseRep> getInterestResponse() {
        return interestResponse;
    }

    public void setInterestResponse(Set<InterestResponseRep> interestResponse) {
        this.interestResponse = interestResponse;
    }

    public void addInterestResponse(Set<InterestResponseRep> interestResponseRep){
        interestResponseRep.forEach(e -> e.setInterest(this));
        interestResponse.addAll(interestResponseRep);
    }
}

