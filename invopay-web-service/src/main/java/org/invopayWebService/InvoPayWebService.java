package org.invopayWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InvoPayWebService {
    public static void main(String[] args) {
        SpringApplication.run(InvoPayWebService.class,args);
    }
}
