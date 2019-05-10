package com.restowa.controllers;
import com.restowa.bl.concrete.AddressManager;
import com.restowa.bl.concrete.TypeUserManager;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.TypeUser;
import com.restowa.domain.model.UserAccount;
import java.util.Date;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Damien
 */

@Controller 
public class RegisterController {
    @Resource
    UserAccountManager uamanager;
        
    @Resource
    TypeUserManager tumanager;
    
    @Resource
    AddressManager amanager;
    
    private final Logger logger = Logger.getLogger(RegisterController.class);
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        logger.info("start register view");
        model.addAttribute("userform", new UserAccount());
        logger.info("end register view");
        return "register";
    }
    

        @RequestMapping(value= "/register", method= RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("userform") UserAccount user, BindingResult result, ModelMap map) {
        logger.info("start register");
        if (result.hasErrors()) {
            logger.info("end register");
            return "register";
        }
        else{
            user.setActive(true);
            user.setCreationDate(new Date());
            user.setLastModificationDate(new Date());
            user.setRemoved(false);
            TypeUser type = tumanager.getTypeUserById(2);
            user.setType(type);
            int idUser = uamanager.insertUserAccount(user);
                map.addAttribute("success",true);
                map.addAttribute("titre","Création");
                map.addAttribute("message","Votre compte a bien été créer.");
            logger.info("end register");
            return "index";
        }
 
        
    }
    
    
    
}
