package com.walmarttech.fastcheckout.service;

import com.walmarttech.fastcheckout.dto.CheckoutRequest;
import com.walmarttech.fastcheckout.dto.CheckoutResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FastCheckoutServiceTest {

    @Mock
    private SortingStrategy sortingStrategy;

    private FastCheckoutService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(sortingStrategy.sort(any())).thenAnswer(invocation -> {
            int[] arr = invocation.getArgument(0);
            Arrays.sort(arr);
            return arr;
        });
        service = new FastCheckoutService(sortingStrategy);
    }

    @Test
    void calcularClientesAtendidos_NormalCase() {
        CheckoutRequest request = new CheckoutRequest();
        request.setTiempoTotal(30);
        request.setTiemposAtencion(Arrays.asList(5, 3, 10, 2, 7));

        CheckoutResponse response = service.calcularClientesAtendidos(request);

        assertEquals(5, response.getClientesAtendidos()); // 2+3+5+7+10=27 <=30
        assertEquals(27, response.getTiempoAcumulado());
    }

    @Test
    void calcularClientesAtendidos_EmptyList_ThrowsException() {
        CheckoutRequest request = new CheckoutRequest();
        request.setTiempoTotal(30);
        request.setTiemposAtencion(Arrays.asList());

        assertThrows(IllegalArgumentException.class, () -> service.calcularClientesAtendidos(request));
    }

    // Más tests: tiempoTotal=0, tiempos negativos (fallan validación), etc.
}