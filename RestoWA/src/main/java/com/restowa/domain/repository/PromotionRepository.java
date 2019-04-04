package com.restowa.domain.repository;

import com.restowa.domain.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    
}
