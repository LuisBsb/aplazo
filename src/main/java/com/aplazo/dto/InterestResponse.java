package com.aplazo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
public class InterestResponse {
    private Integer payment_number;
    private Double amount;
    private Date payment_date;
}
