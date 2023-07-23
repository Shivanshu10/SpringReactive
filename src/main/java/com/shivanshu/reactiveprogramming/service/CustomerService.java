package com.shivanshu.reactiveprogramming.service;

import com.shivanshu.reactiveprogramming.dao.CustomerDAO;
import com.shivanshu.reactiveprogramming.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> loadAllCustomers() {
        long startTime = System.currentTimeMillis();
        List<Customer> customers = customerDAO.getCustomer();
        long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time: "+(endTime-startTime));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long startTime = System.currentTimeMillis();
        Flux<Customer> customers = customerDAO.getCustomerStream();
        long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time: "+(endTime-startTime));
        return customers;
    }
}
