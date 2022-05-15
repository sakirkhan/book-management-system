package com.getir.assignment.repository;

import com.getir.assignment.entity.Book;
import com.getir.assignment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    Optional<Book> findByNameAndAuthorName(String name, String author_name);
//
//    Optional<Book> findByName(String name);
}
