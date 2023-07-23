package com.shivanshu.reactiveprogramming.dao;

import com.shivanshu.reactiveprogramming.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {
    // dao as publisher

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDAO::sleepExecution)
                .peek(i-> System.out.println("processing count: "+i))
                .mapToObj(i->new Customer(i, "customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing Count: "+i))
                .map(i -> new Customer(i, "Customer"+i));
    }
}
