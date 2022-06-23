package com.aplazo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InterestResponse {
    private Integer payment_number;
    private Double amount;
    private Date payment_date;
}
