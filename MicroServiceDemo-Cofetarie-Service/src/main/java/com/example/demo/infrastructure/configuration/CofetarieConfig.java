package com.example.demo.infrastructure.configuration;

import com.example.demo.service.CofetarieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CofetarieConfig {
    @Value("${addressservice.base.url}")
    private String addressBaseUrl;

//    @Bean
//    public CofetarieService cofetarieBean() {
//        return new CofetarieService();
//    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(addressBaseUrl).build();
    }


}