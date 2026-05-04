package com.example.carbontracker.service;

import com.example.carbontracker.entity.CarbonEntry;
import com.example.carbontracker.repository.CarbonEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarbonEntryService {

    private final CarbonEntryRepository repository;

    public CarbonEntryService(CarbonEntryRepository repository) {
        this.repository = repository;
    }

    // GET ALL DATA
    public List<CarbonEntry> getAll() {
        return repository.findAll();
    }

    // CREATE
    public CarbonEntry create(CarbonEntry entry) {
        if (entry.getStatus() == null) {
            entry.setStatus("ACTIVE");
        }
        return repository.save(entry);
    }

    // UPDATE
    public CarbonEntry update(Long id, CarbonEntry updated) {
        CarbonEntry existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setActivity(updated.getActivity());
        existing.setCategory(updated.getCategory());
        existing.setCarbonKg(updated.getCarbonKg());
        existing.setDate(updated.getDate());
        existing.setStatus(updated.getStatus());

        return repository.save(existing);
    }

    // DELETE (SOFT REMOVE OPTIONAL)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}