package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String ownerName;

    public BookService(String ownerName) {
        this.ownerName = ownerName;
        System.out.println("Constructor Injection: Owner - " + ownerName);
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection: Repository injected");
    }

    public void addBook(String title) {
        System.out.println("[" + ownerName + "] Adding book: " + title);
        bookRepository.saveBook(title);
    }
}
