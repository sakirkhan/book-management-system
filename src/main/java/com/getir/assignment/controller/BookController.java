package com.getir.assignment.controller;

import com.getir.assignment.dto.BookDTO;
import com.getir.assignment.dto.CustomerDTO;
import com.getir.assignment.entity.Book;
import com.getir.assignment.entity.Customer;
import com.getir.assignment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @PostMapping("book/register")
    public ResponseEntity<?> registerBook(@RequestBody BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepository.findByNameAndAuthorName(bookDTO.getName(), bookDTO.getAuthorName());
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setQuantity(book.getQuantity() + bookDTO.getQuantity());
            return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);

        } else {
            // create book object
            Book book = new Book();
            book.setName(bookDTO.getName());
            book.setAuthorName(bookDTO.getAuthorName());
            book.setQuantity(bookDTO.getQuantity());

            return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
        }
    }
    @GetMapping("book")
    public ResponseEntity<List<Book>> getBook(){
        return new ResponseEntity<>((List<Book>) bookRepository.findAll(), HttpStatus.OK);
    }

}
