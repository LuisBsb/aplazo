package com.aplazo;

import com.aplazo.controller.InterestController;
import com.aplazo.dto.InterestRequest;
import com.aplazo.dto.InterestResponse;
import com.aplazo.exceptions.InvalidFieldsException;
import com.aplazo.repository.Interest;
import com.aplazo.repository.InterestRepository;
import com.aplazo.repository.InterestResponseRep;
import com.aplazo.service.InterestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

    @MockBean
    private InterestRepository interestRepository;

    @Test
    public void main() {
        AplazoApplication.main(new String[] {});
    }

    @Test
    void interest() throws Exception {
        Set<InterestResponse> response = interestService.interest(InterestMock.getInterestRequest());
        assertNotNull(response);
        assertEquals(5, response.size());
        assertEquals(2.02, response.stream().findFirst().get().getAmount());
    }

    @Test
    void interestInvalidFieldsException() throws InvalidFieldsException {
        try {
            when(interestService.interest(null)).thenThrow(InvalidFieldsException.class);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid fields insert.");
        }
    }

}
