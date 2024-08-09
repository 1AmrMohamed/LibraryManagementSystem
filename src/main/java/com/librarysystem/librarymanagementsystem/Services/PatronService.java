package com.librarysystem.librarymanagementsystem.Services;




import com.librarysystem.librarymanagementsystem.Entity.Patron;
import com.librarysystem.librarymanagementsystem.Repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Cacheable("patrons")
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patron) {
        if (patronRepository.existsById(id)) {
            patron.setId(id);
            return patronRepository.save(patron);
        }
        return null;
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}

