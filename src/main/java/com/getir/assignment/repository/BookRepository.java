package com.getir.assignment.repository;

import com.getir.assignment.entity.Book;
import com.getir.assignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Id> {


    Optional<Book> findByNameAndAuthorName(String name,String author_name);

    Optional<Book> findByName(String name);

    Book findById(Long id);
}
