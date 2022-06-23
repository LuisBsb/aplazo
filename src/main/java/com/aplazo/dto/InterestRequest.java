package com.aplazo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class InterestRequest {
    @NotNull
    Double amount;

    @NotNull
    Integer terms;

    @NotNull
    Double rate;
}
