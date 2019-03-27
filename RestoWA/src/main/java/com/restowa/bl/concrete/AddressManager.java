package com.restowa.bl.concrete;

import com.restowa.domain.model.Address;
import com.restowa.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressManager {

    private AddressRepository repo;

    public AddressManager() {

    }

    @Autowired
    public AddressManager(AddressRepository arepo) {
        this.repo = arepo;
    }

    public Address getAddressById(int id) {
        return this.repo.findById(id).get();
    }
}
