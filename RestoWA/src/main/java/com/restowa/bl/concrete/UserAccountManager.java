package com.restowa.bl.concrete;

import com.restowa.domain.model.UserAccount;
import com.restowa.domain.repository.UserAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountManager {

    private UserAccountRepository repo;

    public UserAccountManager() {

    }

    @Autowired
    public UserAccountManager(UserAccountRepository uarepo) {
        this.repo = uarepo;
    }

    public UserAccount getUserAccountById(int id) {
        return this.repo.findById(id).get();
    }
    
    public List<UserAccount> getUserAccountByEmailAndPassword(String email,String password) {
        return this.repo.findByEmailAndPassword(email,password);
    }
    
    public Long checkUserAccountByEmailAndPassword(String email,String password) {
        return this.repo.checkByEmailAndPassword(email,password).get(0);
    }
    
    public int insertUserAccount(UserAccount user) {
        return this.repo.saveAndFlush(user).getID();
    }
}
