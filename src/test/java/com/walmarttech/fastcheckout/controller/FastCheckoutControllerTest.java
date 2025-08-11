package com.walmarttech.fastcheckout.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmarttech.fastcheckout.dto.CheckoutRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FastCheckoutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void calcular_ValidRequest_ReturnsOk() throws Exception {
        CheckoutRequest request = new CheckoutRequest();
        request.setTiempoTotal(30);
        request.setTiemposAtencion(Arrays.asList(5, 3, 10, 2, 7));

        mockMvc.perform(post("/api/fast-checkout/calcular")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clientesAtendidos").value(5))
                .andExpect(jsonPath("$.tiempoAcumulado").value(27));
    }

    // Más tests: invalid input, simular-cola, etc.
}