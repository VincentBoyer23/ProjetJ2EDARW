package com.restowa.domain.repository;

import com.restowa.domain.model.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Integer> {
    
}