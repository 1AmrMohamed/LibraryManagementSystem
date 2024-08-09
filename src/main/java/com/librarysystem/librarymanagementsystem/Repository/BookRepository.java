package com.librarysystem.librarymanagementsystem.Repository;



import com.librarysystem.librarymanagementsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
