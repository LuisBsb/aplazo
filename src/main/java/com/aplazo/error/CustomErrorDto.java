package com.aplazo.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomErrorDto {
    public Integer status;
    public String error;
}
