package com.walmarttech.fastcheckout.config;

import com.walmarttech.fastcheckout.service.DefaultSortingStrategy;
import com.walmarttech.fastcheckout.service.SortingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SortingStrategy sortingStrategy() {
        return new DefaultSortingStrategy();
    }
}