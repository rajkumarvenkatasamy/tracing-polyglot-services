/**
 * @author Rajkumar Venkatasamy
 */

package com.rajkumarvenkatasamy.javaspringreactiveservice.controller;

import com.rajkumarvenkatasamy.javaspringreactiveservice.service.ExternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("java-service")
public class ExternalServiceCallController {

    ExternalService externalService;

    @Autowired
    public ExternalServiceCallController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/api/v1/internal/greetings")
    String greetings() {
        return "Greeting from Java Spring Reactive App";
    }

    @GetMapping("/api/v1/external/greetings")
    String getGreetingFromExternalService() {
        return externalService.getGreetingFromPythonFlaskService();
    }

    @GetMapping("/api/v1/external/belated-greetings")
    String getBelatedGreetingFromExternalService() throws InterruptedException {
        return externalService.getBelatedGreetingFromPythonFlaskService();
    }
}
