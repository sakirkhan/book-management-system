package com.getir.assignment.controller;

import com.getir.assignment.dto.BookDTO;
import com.getir.assignment.dto.OrderDTO;
import com.getir.assignment.entity.Book;
import com.getir.assignment.entity.Order;
import com.getir.assignment.repository.BookRepository;
import com.getir.assignment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;
    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        Book book = bookRepository.findById(orderDTO.getBookId());
        if (book.getQuantity()-orderDTO.getQuantities() < 0) {
            return new ResponseEntity<>("Books are not available", HttpStatus.BAD_REQUEST);
        }
        //reserve the books
        book.setQuantity(book.getQuantity()-orderDTO.getQuantities());
        bookRepository.save(book);


        // create order object
       Order order = new Order();
       order.setCustomerId(orderDTO.getCustomerId());
       order.setBookId(orderDTO.getBookId());
       order.setQuantities(orderDTO.getQuantities());
       return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getOrder(){
        List<Order> orders =  orderRepository.findAll();
        List<OrderDTO> orderDTOS = orders.stream().map(OrderDTO::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(orderDTOS, HttpStatus.OK);
    }

    @GetMapping("{orderId}/details")
    public ResponseEntity<OrderDTO> getOrderDetail(@PathVariable Long orderId){
        Optional <Order> order =  orderRepository.findById(orderId);
        return new ResponseEntity<>(OrderDTO.toDTO(order.get()), HttpStatus.OK);
    }
}
