package com.aplazo.controller;

import com.aplazo.dto.InterestRequest;
import com.aplazo.dto.InterestResponse;
import com.aplazo.exceptions.InvalidFieldsException;
import com.aplazo.service.InterestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/aplazo")
public class InterestController {

    InterestService interestService;

    @PostMapping("/interest")
    public List<InterestResponse> registerStudent(@RequestBody InterestRequest interestRequest) throws InvalidFieldsException {
        return interestService.interest(interestRequest);
    }

}
