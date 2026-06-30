package com.example.reactivestreamfundamentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveStreamFundamentalsApplication {

    public static void printFluxRange() {
        System.out.println("1. Printing Flux Range:");
        Flux.range(1, 5)
                .subscribe(
                        value -> System.out.println("Received: " + value),                  // Consumer
                        error -> System.out.println("Error: " + error.getMessage()),     // Error Handler
                        () -> System.out.println("Completed")                                     // Completion Handler
                );
    }

    public static void printObserveDemand() {
        System.out.println("\n2. Printing Flux Range with Observe Demand:");
        Flux.range(1, 5)
                .doOnRequest(request -> System.out.println("Requested: " + request))
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveStreamFundamentalsApplication.class, args);
        printFluxRange();
        printObserveDemand();
    }

}
