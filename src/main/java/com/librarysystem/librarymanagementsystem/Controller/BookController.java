package com.librarysystem.librarymanagementsystem.Controller;


import com.librarysystem.librarymanagementsystem.Entity.Book;
import com.librarysystem.librarymanagementsystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apibooks")
public class BookController {
    @Autowired
    private BookService bookService;
    @Cacheable
    @GetMapping("/getbooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/newbooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        List<Book> savedBooks = new ArrayList<>();
        for (Book book : books) {
            savedBooks.add(bookService.saveBook(book));
        }
        return savedBooks;

    }


    @Cacheable
    @PutMapping("/updatebooks{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
    @Cacheable
    @DeleteMapping("/deletebooks{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
