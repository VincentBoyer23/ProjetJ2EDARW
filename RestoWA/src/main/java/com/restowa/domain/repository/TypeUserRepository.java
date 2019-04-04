package com.restowa.domain.repository;

import com.restowa.domain.model.TypeUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
    
    @Query("SELECT t FROM TypeUser t WHERE type=:type")
    public List<TypeUser> findTypeByType(@Param("type") String type);
    
}
