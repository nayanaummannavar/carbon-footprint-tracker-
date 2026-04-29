
package com.example.carbontracker.controller;

import com.example.carbontracker.entity.CarbonEntry;
import com.example.carbontracker.service.CarbonEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/")
public class CarbonEntryController {

    private final CarbonEntryService service;

    public CarbonEntryController(CarbonEntryService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<CarbonEntry> getAll() {
        return service.getAll();
    }

    @PostMapping("/add")
    public CarbonEntry add(@RequestBody CarbonEntry entry) {
        return service.create(entry);
    }

    @PutMapping("/{id}")
    public CarbonEntry update(@PathVariable Long id, @RequestBody CarbonEntry entry) {
        return service.update(id, entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}