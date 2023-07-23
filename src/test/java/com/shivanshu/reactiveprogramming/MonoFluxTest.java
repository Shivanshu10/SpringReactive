package com.shivanshu.reactiveprogramming;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMone() {
        // this is publisher
        Mono<?> monoString = Mono.just("shivanshu")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        // subscribe for evenets of publisher with a func called on no error and when error occurs
        monoString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        // flux multiple objects
        Flux<String> fluxString = Flux.just("Spring", "Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception Occured In flux")))
                .concatWithValues("Cloud")
                .log();

        fluxString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }
}
