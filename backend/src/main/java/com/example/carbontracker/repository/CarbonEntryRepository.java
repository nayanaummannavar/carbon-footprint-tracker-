package com.example.carbontracker.repository;

import com.example.carbontracker.entity.CarbonEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonEntryRepository extends JpaRepository<CarbonEntry, Long> {
}