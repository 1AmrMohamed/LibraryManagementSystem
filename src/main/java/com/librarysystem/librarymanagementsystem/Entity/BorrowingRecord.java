package com.librarysystem.librarymanagementsystem.Entity;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Service
@Cacheable()
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id", referencedColumnName = "id")
    private Patron patron;

    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowingDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setBookId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
