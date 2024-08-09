package com.librarysystem.librarymanagementsystem.Repository;

import com.librarysystem.librarymanagementsystem.Entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
}
