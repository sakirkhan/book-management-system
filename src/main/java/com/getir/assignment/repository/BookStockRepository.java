package com.getir.assignment.repository;

import com.getir.assignment.entity.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface BookStockRepository extends JpaRepository<BookStock, Id> {
}
