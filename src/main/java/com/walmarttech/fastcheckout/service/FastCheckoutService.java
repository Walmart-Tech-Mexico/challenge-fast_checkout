package com.walmarttech.fastcheckout.service;

import com.walmarttech.fastcheckout.dto.CheckoutRequest;
import com.walmarttech.fastcheckout.dto.CheckoutResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class FastCheckoutService {
    private static final Logger logger = LoggerFactory.getLogger(FastCheckoutService.class);
    private final SortingStrategy sortingStrategy;

    public FastCheckoutService(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public CheckoutResponse calcularClientesAtendidos(CheckoutRequest request) {
        if (request.getTiemposAtencion().isEmpty()) {
            throw new IllegalArgumentException("La lista de tiempos no puede estar vacía");
        }

        int[] tiemposOrdenados = sortingStrategy.sort(request.getTiemposAtencion().stream().mapToInt(Integer::intValue).toArray());

        CheckoutResponse response = new CheckoutResponse();
        final int[] acumulado = {0};

        // Uso de streams y lambda para acumulación eficiente
        int count = (int) IntStream.of(tiemposOrdenados)
                .takeWhile(tiempo -> {
                    if (acumulado[0] + tiempo <= request.getTiempoTotal()) {
                        acumulado[0] += tiempo;
                        return true;
                    }
                    return false;
                })
                .count();

        response.setClientesAtendidos(count);
        response.setTiempoAcumulado(acumulado[0]);
        logger.info("Clientes atendidos: {}, Tiempo acumulado: {}", count, acumulado[0]);
        return response;
    }
}