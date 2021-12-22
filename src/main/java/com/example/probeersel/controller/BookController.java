package com.example.probeersel.controller;

import com.example.probeersel.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //attribute
    private List<Book> books = new ArrayList<>();

    //constructor
    public BookController() {
        Book boek1 = new Book();
        boek1.setTitle("Harry Potter");
        boek1.setAuthor("J. K. Rowling");
        boek1.setIsbn("2346837290");
        books.add(boek1);

        Book boek2 = new Book();
        boek2.setTitle("Harry Potter, deel 2");
        boek2.setAuthor("J. K. Rowling");
        boek2.setIsbn("7468564901");
        books.add(boek2);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks() {
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        return ResponseEntity.ok(books.get(id));
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book)  {
        books.add(book);

        int newId = books.size() - 1;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book) {
        books.set(id, book);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/books/{id}")
    public ResponseEntity<Object> partialUpdateBook(@PathVariable int id, @RequestBody Book book) {
        Book existingBook = books.get(id);
        if (!book.getTitle().isEmpty()) {
            existingBook.setTitle(book.getTitle());
        }
        if (!book.getAuthor().isEmpty()) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (!book.getIsbn().isEmpty()) {
            existingBook.setIsbn(book.getIsbn());
        }
        books.set(id, book);
        return ResponseEntity.noContent().build();
    }
}
