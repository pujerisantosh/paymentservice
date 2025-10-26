package dev.santosh.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PaymentServiceApplication.class);
        app.setLazyInitialization(true); // Lazy init for all beans
        app.run(args);
    }

}
