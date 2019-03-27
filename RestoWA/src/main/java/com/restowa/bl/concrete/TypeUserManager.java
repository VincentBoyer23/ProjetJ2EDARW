package com.restowa.bl.concrete;

import com.restowa.domain.model.TypeUser;
import com.restowa.domain.repository.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeUserManager {

    private TypeUserRepository repo;

    public TypeUserManager() {

    }

    @Autowired
    public TypeUserManager(TypeUserRepository turepo) {
        this.repo = turepo;
    }

    public TypeUser getTypeUserById(int id) {
        return this.repo.findById(id).get();
    }
}
