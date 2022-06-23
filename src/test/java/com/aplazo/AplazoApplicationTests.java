package com.aplazo;

import com.aplazo.controller.InterestController;
import com.aplazo.dto.InterestRequest;
import com.aplazo.dto.InterestResponse;
import com.aplazo.repository.Interest;
import com.aplazo.repository.InterestResponseRep;
import com.aplazo.service.InterestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
class AplazoApplicationTests {

    @Autowired
    private InterestService interestService;

    private Interest interest;

    private InterestResponseRep interestResponseRep;

    private InterestRequest interestRequest;

    private Set<InterestResponseRep> interestResponse = new HashSet<InterestResponseRep>();

    private Set<InterestResponse> response = new HashSet<InterestResponse>();

    @BeforeEach
    public void initMocks() {
        interest = new Interest();
        interest.setTerms(5);
        interest.setRate(30.0);
        interest.setAmount(10.0);
        interestRequest = new InterestRequest();
        interestRequest.setTerms(4);
        interestRequest.setAmount(30.0);
        interestRequest.setRate(5.0);
        interestResponseRep = InterestResponseRep.builder().amount(interest.getAmount()).payment_number(2).payment_date(new Date()).interest(interest).build();
        interestResponse.add(interestResponseRep);
        response.add(InterestResponse.builder().amount(4.0).payment_date(new Date()).payment_number(1).build());
    }
//    @Test
//    public void main() {
//        AplazoApplication.main(new String[] {});
//    }
//
//    @Test
//    void registerStudent() throws Exception {
//        Set<InterestResponse> response = interestService.interest(interestRequest);
//        assertNotNull(response);
//        assertEquals(4, response.size());
//    }

}
