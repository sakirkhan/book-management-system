package com.getir.assignment.repository;

import com.getir.assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BookRepository  extends JpaRepository<Book, Id> {
}
