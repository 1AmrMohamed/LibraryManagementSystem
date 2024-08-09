package com.librarysystem.librarymanagementsystem.Services;




import com.librarysystem.librarymanagementsystem.Entity.BorrowingRecord;
import com.librarysystem.librarymanagementsystem.Repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Cacheable("books")
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public BorrowingRecord getBorrowingRecordById(Long id) {
        return borrowingRecordRepository.findById(id).orElse(null);
    }

    public BorrowingRecord saveBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    public BorrowingRecord updateBorrowingRecord(Long id, BorrowingRecord borrowingRecord) {
        if (borrowingRecordRepository.existsById(id)) {
            borrowingRecord.getPatron().setId(id);
            return borrowingRecordRepository.save(borrowingRecord);
        }
        return null;
    }

    public void deleteBorrowingRecord(Long id) {
        borrowingRecordRepository.deleteById(id);
    }

    public BorrowingRecord findByBookIdAndPatronId(Long bookId, Long patronId) {
            return null;
    }
}
