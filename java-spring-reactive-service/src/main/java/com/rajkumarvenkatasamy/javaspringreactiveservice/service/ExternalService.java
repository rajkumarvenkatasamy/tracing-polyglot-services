/**
 * @author Rajkumar Venkatasamy
 */

package com.rajkumarvenkatasamy.javaspringreactiveservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class ExternalService {

    private final WebClient webClient;

    @Autowired
    public ExternalService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Value("${api.gateway.base.url}")
    private String apiGatewayBaseUrl;

    public String getGreetingFromPythonFlaskService() {

        return this.webClient
                .get()
                .uri(apiGatewayBaseUrl + "/python-flask-service/api/v1/greetings")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(15))
                .share()
                .block();

    }

    public String getBelatedGreetingFromPythonFlaskService() {
        return this.webClient
                .get()
                .uri(apiGatewayBaseUrl + "/python-flask-service/api/v1/belated-greetings")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(15))
                .share()
                .block();
    }
}
