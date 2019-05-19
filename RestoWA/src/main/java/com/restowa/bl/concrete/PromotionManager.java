package com.restowa.bl.concrete;

import com.restowa.domain.model.Promotion;
import com.restowa.domain.repository.PromotionRepository;
import java.util.Date;
import java.util.List;
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
    
    public List<Promotion> getAllPromotions(){
        return this.repo.findAll();
    }
    
    public int inserPromotion(Promotion promotion){
        return this.repo.saveAndFlush(promotion).getId();
    }
    
    public void updatePromotion(Promotion promotion){
        this.repo.save(promotion);
    }
    
    public void deletePromotion(Promotion promotion){
        this.repo.delete(promotion);
    }
    
    public List<Promotion> getPromotionsByDate(Date date){
        return this.repo.filterPromotionByDate(date);
    }
    
    public List<Promotion> getPromotionsByWord(String word){
        return this.repo.filterPromotionByTitle(word);
    }
    
    public List<Promotion> getPromotionByKey(String key){
        return this.repo.filterPromotionByKey(key);
    }
    
    public List<Promotion> getPromotionByOwner(int idowner){
        return this.repo.filterPromotionByOwner(idowner);
    }
    
}
