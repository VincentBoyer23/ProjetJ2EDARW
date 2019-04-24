
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
        UserAccount ua = uamanager.getUserAccountById(1);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        map.put("userId", ua.getID());
        map.put("userName", ua.getFirstname() + " " + ua.getLastname());
        map.put("idType",ua.getType().getID());
        map.put("userType", ua.getType().getType());
        return "index";
    }
    
}
