package com.walmarttech.fastcheckout.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class DefaultSortingStrategy implements SortingStrategy {
    @Override
    public int[] sort(int[] tiempos) {
        Arrays.sort(tiempos);
        return tiempos;
    }
}