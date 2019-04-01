
package com.restowa.controllers;

import com.restowa.bl.concrete.AddressManager;
import com.restowa.bl.concrete.TypeUserManager;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeUser;
import com.restowa.domain.model.UserAccount;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

//    @Resource
//    UserAccountRepository repo;
    
    @Resource
    UserAccountManager uamanager;
    
    @Resource
    TypeUserManager tumanager;
    
    @Resource
    AddressManager amanager;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {
        
        //UserAccount ua = repo.findById(1).get();
        UserAccount ua = uamanager.getUserAccountByEmailAndPassword("r.tibbers@truc.com","password").get(0);
        UserAccount user = new UserAccount();
        user.setFirstname("ief");
        user.setLastname("iehfihe");
        user.setActive(true);
        user.setEmail("nergfe@oienrg.com");
        user.setCreationDate(Date.from(Instant.now()));
        user.setLastModificationDate(Date.from(Instant.now()));
        user.setPhoneNumber("65465e4gf");
        user.setPassword("kdie");
        user.setRemoved(false);
        user.setResetLinkValidateDate(Date.from(Instant.now()));
        user.setResetPasswordLink("jhbiebg");
        user.setType(tumanager.getTypeUserById(1));
        user.setAddress(amanager.getAddressById(1));
        int newId = uamanager.insertUserAccount(user);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        map.put("userId", ua.getID());
        map.put("userName", ua.getFirstname() + " " + ua.getLastname());
        map.put("newId", newId);
        return "index";
    }
    
}
