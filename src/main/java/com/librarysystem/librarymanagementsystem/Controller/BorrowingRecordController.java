package com.librarysystem.librarymanagementsystem.Controller;


import com.librarysystem.librarymanagementsystem.Entity.BorrowingRecord;
import com.librarysystem.librarymanagementsystem.Services.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @GetMapping
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordService.getAllBorrowingRecords();
    }

    @GetMapping("/{id}")
    public BorrowingRecord getBorrowingRecordById(@PathVariable Long id) {
        return borrowingRecordService.getBorrowingRecordById(id);
    }

    @PostMapping("/{bookId}/patron/{patronId}")
    public BorrowingRecord borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBookId(bookId);
        borrowingRecord.getPatron().setId(patronId);
        borrowingRecord.setBorrowingDate(new Date());
        return borrowingRecordService.saveBorrowingRecord(borrowingRecord);
    }

    @PutMapping("/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.findByBookIdAndPatronId(bookId, patronId);
        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(new Date());
            return borrowingRecordService.updateBorrowingRecord(borrowingRecord.getPatron().setId(patronId), borrowingRecord);
        }
        return null;
    }
}
