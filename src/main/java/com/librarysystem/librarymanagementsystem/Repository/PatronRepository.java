package com.librarysystem.librarymanagementsystem.Repository;


import com.librarysystem.librarymanagementsystem.Entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
}
