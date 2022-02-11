/**
 * @author Rajkumar Venkatasamy
 */

package com.rajkumarvenkatasamy.javaspringreactiveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JavaSpringReactiveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringReactiveServiceApplication.class, args);
	}

}
