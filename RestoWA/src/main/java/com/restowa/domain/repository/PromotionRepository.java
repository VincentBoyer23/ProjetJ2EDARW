package com.restowa.domain.repository;

import com.restowa.domain.model.Promotion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    
    @Query("SELECT p FROM Promotion p WHERE startdate<=:date AND endate>=:date")
    public List<Promotion> filterPromotionByDate(@Param(":date") Date date);
    
    @Query("SELECT p FROM Promotion p WHERE title LIKE CONCAT(CONCAT('%',:word),'%')")
    public List<Promotion> filterPromotionByTitle(@Param("word") String word);
    
    @Query("SELECT p FROM Promotion p WHERE key LIKE CONCAT(CONCAT('%',:word),'%')")
    public List<Promotion> filterPromotionByKey(@Param("word") String word);
    
}
