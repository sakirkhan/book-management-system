package com.getir.assignment.controller;

import com.getir.assignment.dto.CustomerDTO;
import com.getir.assignment.entity.Customer;
import com.getir.assignment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("customer/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO){
        // add check for email exists in a DB
        if(customerRepository.existsByEmail(customerDTO.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create customer object
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());

        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }

    @GetMapping("customer")
    public ResponseEntity<List<Customer>> getCustomer(){
        return new ResponseEntity<>((List<Customer>) customerRepository.findAll(), HttpStatus.OK);
    }
}
