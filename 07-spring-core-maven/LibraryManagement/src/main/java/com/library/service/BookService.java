package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

/**
 * Business service for books. Demonstrates both constructor injection (Ex 7)
 * and setter injection (Ex 2 & 7). @Service supports the annotation config (Ex 6).
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    // Constructor injection (Ex 7)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter injection (Ex 2 & 7)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public String findBook() {
        return bookRepository.getBook();
    }
}
