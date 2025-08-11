package com.walmarttech.fastcheckout.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CheckoutRequest {
    @NotNull @Min(1)
    private Integer tiempoTotal;
    @NotEmpty
    private List<@Min(1) Integer> tiemposAtencion;
}