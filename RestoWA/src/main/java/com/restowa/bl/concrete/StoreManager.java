package com.restowa.bl.concrete;

import com.restowa.domain.model.Store;
import com.restowa.domain.repository.StoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreManager {

    private StoreRepository repo;

    public StoreManager() {

    }

    @Autowired
    public StoreManager(StoreRepository srepo) {
        this.repo = srepo;
    }

    public Store getStoreById(int id) {
        return this.repo.findById(id).get();
    }
    
    public List<Store> getAllStore(){
        return this.repo.findAll();
    }
    
    public List<Store> getStoresByKeywords(String query){
        return this.repo.findByKeyword(query);
    }
    
    public int insertStore(Store store){
        return this.repo.saveAndFlush(store).getID();
    }
    
    public void updateStore(Store store){
        this.repo.save(store);
    }
    
    public void deleteStore(Store store){
        this.repo.delete(store);
    }
}
