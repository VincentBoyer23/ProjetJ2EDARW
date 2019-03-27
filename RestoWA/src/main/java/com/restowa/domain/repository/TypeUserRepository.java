package com.restowa.domain.repository;

import com.restowa.domain.model.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
    
}
