package com.aplazo.service;

import com.aplazo.dto.InterestRequest;
import com.aplazo.dto.InterestResponse;
import com.aplazo.exceptions.InvalidFieldsException;
import com.aplazo.repository.Interest;
import com.aplazo.repository.InterestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class InterestService {

    @Autowired
    InterestRepository interestRepository;

    public List<InterestResponse> interest(InterestRequest interestRequest) throws InvalidFieldsException {
        validateFields(interestRequest);
        interestRepository.save(Interest.builder().request(interestRequest.toString()).build());
        return calculateInterest(interestRequest);
    }
    private List<InterestResponse> calculateInterest(InterestRequest interestRequest) {
        List<InterestResponse> list = new ArrayList<>();
        Double amount = interestRequest.getAmount();
        Integer terms = interestRequest.getTerms();
        Double  rate  = interestRequest.getRate();

        Double totalPay = amount + (rate / 100) * amount;
        Double totalPayment = totalPay / terms;

        for (int i = 0; i < terms; i++) {
            InterestResponse interestResponse = new InterestResponse();
            interestResponse.setPayment_number(i);
            interestResponse.setAmount(totalPayment);
            interestResponse.setPayment_date(new Date());
            list.add(interestResponse);
        }

        return list;
    }

    private void validateFields(InterestRequest interestRequest) throws InvalidFieldsException {
        if( interestRequest == null || interestRequest.getAmount() == 0 || interestRequest.getRate() == 0 || interestRequest.getTerms() == 0)
            throw new InvalidFieldsException("Invalid fields insert.");

        if (interestRequest.getTerms() <5 || interestRequest.getTerms() > 52)
            throw new InvalidFieldsException("The max terms (weeks) were the payment can be paid is 52, the minimum should be 4.");

        if (interestRequest.getRate() <1 || interestRequest.getRate() > 100)
            throw new InvalidFieldsException("The rate should bigger than 1%, lesser than 100%.");

        if (interestRequest.getRate() <1 || interestRequest.getRate() > 100)
            throw new InvalidFieldsException("The amount should be more than $1.00, the max should be lesser than $999,999.00");
    }
}
