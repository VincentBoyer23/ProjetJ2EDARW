package com.restowa.bl.concrete;

import com.restowa.domain.model.Promotion;
import com.restowa.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionManager {

    private PromotionRepository repo;

    public PromotionManager() {

    }

    @Autowired
    public PromotionManager(PromotionRepository prepo) {
        this.repo = prepo;
    }

    public Promotion getPromotionById(int id) {
        return this.repo.findById(id).get();
    }
}
