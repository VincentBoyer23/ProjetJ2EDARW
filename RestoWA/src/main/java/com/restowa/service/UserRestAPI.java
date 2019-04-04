/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeUser;
import com.restowa.domain.model.UserAccount;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.annotation.Resource;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * REST Web Service
 *
 * @author vinceduroc
 */
@RestController
@RequestMapping("/api/user")
public class UserRestAPI {

    
    @Resource
    UserAccountManager uamanager;

    /**
     * Creates a new instance of AuthetificationResource
     */
    public UserRestAPI() {
    }

    
    @RequestMapping(value = "/postauthentification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String postauthJson(@RequestBody String content) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(content);
            /*on check si l'user est dans la bdd*/
            Long countuser = uamanager.checkUserAccountByEmailAndPassword((String) obj.get("email"), (String) obj.get("password"));
            /*on recupere l'utilisateur*/
            
            if(countuser!=0)
            {
                obj.put("iduser", users.get(0).getID());
                obj.put("authentificate", true);
                return obj.toString();
            }
            obj.put("authentificate", false);
            return obj.toString();
            
        } catch (ParseException ex) {
            Logger.getLogger(UserRestAPI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        JSONObject obj = new JSONObject();
        return obj.toString();
    }
    
    @RequestMapping(value = "/postregister", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String postregJson(@RequestBody String content) {
        JSONParser parser = new JSONParser();
        
            
        try {
            JSONObject obj;
            obj = (JSONObject) parser.parse(content);
            /*on teste si l'utilisateur est déjà enregistré*/
            List<UserAccount> users = uamanager.getUserAccountByEmailAndPassword((String) obj.get("email"), (String) obj.get("password"));
            if(users.size()!=0)
            {
                obj.put("message", "L'utilisateur est déjà enregistré.");
                return obj.toString();
            }
            
            UserAccount user = new UserAccount();
            user.setFirstname((String) obj.get("firstname"));
            user.setLastname((String) obj.get("lastname"));
            user.setEmail((String) obj.get("email"));
            user.setPassword((String) obj.get("password"));
            user.setPhoneNumber((String) obj.get("phonenumber"));
            user.setActive(true);
            /*date de la création du compte*/
            Date creationdate = new Date();
            user.setCreationDate(creationdate);
            user.setLastModificationDate(creationdate);
            
            user.setResetPasswordLink("");
            /*date de validation de l'adresse */
            Date datevalidation = new Date();
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(datevalidation); // sets calendar time/date
            cal.add(Calendar.HOUR_OF_DAY, 10); // adds 10 hour
            datevalidation = cal.getTime();
            user.setResetLinkValidateDate(datevalidation);
            
            user.setRemoved(false);
            /*mise en place du type d'utilisateur*/
            TypeUser type = new TypeUser();
            type.setType((String) obj.get("type"));
            user.setType(type);
            
            /*mise en place de l'adresse*/
            
            Address address = new Address();
            address.setStreet((String) obj.get("street"));
            address.setCity((String) obj.get("city"));
            address.setState((String) obj.get("state"));
            address.setZipCode((String) obj.get("zipcode"));
            address.setCountry((String) obj.get("country"));
            user.setAddress(address);
            
            int iduser = uamanager.insertUserAccount(user);
            obj.put("iduser", iduser);
            obj.put("message", "Enregistrement terminé");
            return obj.toString();
        } catch (ParseException ex) {
            Logger.getLogger(UserRestAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        JSONObject obj = new JSONObject();
        obj.put("message", "Enregistement impossible");
        return obj.toString();
    }
    
   @GetMapping(value = "/getuserinfo/{iduser}", produces = MediaType.APPLICATION_JSON)
    public String getJson(@PathVariable("iduser") int iduser) {
        JSONObject obj = new JSONObject();
        UserAccount user = uamanager.getUserAccountById(iduser);
        obj.put("firstname", user.getFirstname());
        obj.put("lastname", user.getLastname());
        obj.put("email", user.getEmail());
        /*on ne met pas son mot de passe*/
        obj.put("phonenumber", user.getPhoneNumber());
        obj.put("active", true);
        obj.put("creationdate", user.getCreationDate());
        obj.put("lastmodificationdate", user.getLastModificationDate());
        obj.put("resetpasswordlink", user.getResetPasswordLink());
        obj.put("resetlinkvalidatedate", user.getResetLinkValidateDate());
        obj.put("isremoved", false);
        obj.put("type", user.getType().getType());
        obj.put("street", user.getAddress().getStreet());
        obj.put("city", user.getAddress().getCity());
        obj.put("state", user.getAddress().getState());
        obj.put("zipcode", user.getAddress().getZipCode());
        obj.put("country", user.getAddress().getCountry());
        return obj.toString();
    }
}
