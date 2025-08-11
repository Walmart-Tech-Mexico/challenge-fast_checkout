package com.walmarttech.fastcheckout.dto;

import lombok.Data;

@Data
public class CheckoutResponse {
    private int clientesAtendidos;
    private int tiempoAcumulado;
}