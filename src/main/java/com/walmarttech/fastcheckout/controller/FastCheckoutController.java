package com.walmarttech.fastcheckout.controller;

import com.walmarttech.fastcheckout.dto.CheckoutRequest;
import com.walmarttech.fastcheckout.dto.CheckoutResponse;
import com.walmarttech.fastcheckout.service.FastCheckoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Fast Checkout API", description = "API para simular atención rápida en caja")
@RestController
@RequestMapping("/api/fast-checkout")
public class FastCheckoutController {

    private final FastCheckoutService service;

    @Autowired
    public FastCheckoutController(FastCheckoutService service) {
        this.service = service;
    }

    @Operation(summary = "Calcula el máximo de clientes atendidos")
    @PostMapping("/calcular")
    public ResponseEntity<CheckoutResponse> calcular(@Valid @RequestBody CheckoutRequest request) {
        return ResponseEntity.ok(service.calcularClientesAtendidos(request));
    }

    @Operation(summary = "Simula una cola de clientes con tiempos aleatorios")
    @PostMapping("/simular-cola")
    public ResponseEntity<CheckoutResponse> simularCola(@Valid @RequestBody CheckoutRequest request) {
        // Aquí se podría generar tiempos aleatorios, pero para simplicidad, usar los proporcionados en el test
        // Ejemplo: Añadir lógica para simulación si se desea extender
        return calcular(request); // Reutilizar la lógica
    }
}