package com.aplazo;

import com.aplazo.dto.InterestRequest;
import com.aplazo.repository.Interest;
import com.aplazo.repository.InterestResponseRep;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class InterestMock {

    public static Interest getInterest() {
        final Interest interest = new Interest();
        interest.setTerms(5);
        interest.setAmount(10.0);
        interest.setRate(1.0);
        interest.getTerms();
        interest.getAmount();
        interest.getRate();
        return interest;
    }

    public static InterestRequest getInterestRequest() {
        final InterestRequest interestRequest = new InterestRequest();
        interestRequest.setTerms(5);
        interestRequest.setAmount(10.0);
        interestRequest.setRate(1.0);
        interestRequest.getTerms();
        interestRequest.getAmount();
        interestRequest.getRate();
        return interestRequest;
    }

    public static InterestResponseRep getInterestResponseRep() {
        InterestResponseRep interestResponseRep = new InterestResponseRep();
        interestResponseRep = InterestResponseRep.builder().amount(getInterest().getAmount()).payment_number(0).payment_date(new Date()).interest(getInterest()).build();
        return interestResponseRep;
    }

    public static Set<InterestResponseRep> getResponse() {
        Set<InterestResponseRep> responseReps = new HashSet<>();
        responseReps.add(getInterestResponseRep());
        return responseReps;
    }
}
