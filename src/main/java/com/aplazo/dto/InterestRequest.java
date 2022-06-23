package com.aplazo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterestRequest {
    @NotNull
    Double amount;

    @NotNull
    Integer terms;

    @NotNull
    Double rate;
}
