package com.restowa.domain.repository;

import com.restowa.domain.model.Store;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    
     @Query("SELECT s FROM Store s WHERE s.name LIKE CONCAT(CONCAT('%',:q),'%')")
    public List<Store> findByKeyword(@Param("q") String q);
    
}
