/**
 * @author Rajkumar Venkatasamy
 */

package com.rajkumarvenkatasamy.javaspringreactiveservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("java-service")
public class InternalServiceCallController {

    @GetMapping("/api/v1/internal/greetings")
    String greetings() {
        log.debug("Inside Internal Greetings method in Java app");
        return "Greeting from Java Spring Reactive App";
    }

}
