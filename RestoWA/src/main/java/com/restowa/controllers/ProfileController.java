/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Damien
 */
@Controller
public class ProfileController {
    @Resource
    UserAccountManager uamanager;
    
    private final Logger logger = Logger.getLogger(ProfileController.class);

        @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(required = false) String email,@RequestParam(required = false) String mdp,Model model, HttpSession session){
        logger.info("start login process");
        List<UserAccount> accounts = uamanager.getUserAccountByEmailAndPassword(email, mdp);
            if (accounts.size()>0) {
                
                session.setAttribute("logged", true);
                session.setAttribute("user", accounts.get(0));
            }
        logger.info("end profile view");
        return "index";
    }
    
            @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String doLogout(HttpSession session){
        logger.info("start logout process");
            if ((boolean)session.getAttribute("logged")==true) {
                session.removeAttribute("logged");
                session.removeAttribute("user");
            }
        logger.info("end logout view");
        return "index";
    }
    
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String getProfile(@PathVariable("id") int id,Model model, HttpSession session){
        logger.info("start profile view");
        UserAccount user = (UserAccount)session.getAttribute("user");
        if (user != null && (user.getID() == id || user.getType().getID() == 4)){
             model.addAttribute("userform", uamanager.getUserAccountById(id));
             model.addAttribute("profile", true);
             logger.info("end profile view");
             return "index";
        }
        else{
            model.addAttribute("failure",true);
            model.addAttribute("titre","Accès Refusé");
            model.addAttribute("message","Vous n'avez pas accès à ce profil utilisateur");
            logger.info("end profile view");
            return "index";
        }
       
        
    }
   
        @RequestMapping(value= "/profile/{id}", method= RequestMethod.POST)
    public String saveProfile(@PathVariable("id") int id,@Valid @ModelAttribute("userform") UserAccount user, BindingResult result) {
        logger.info("start profile update");
        if (result.hasErrors()) {
            logger.info("end profile update");
            return "./store/"+id;
        }
        else{
            user.setID(id);
            uamanager.updateUserAccount(user);
            logger.info("end profile update");
           return "success";
        }
        }
}
