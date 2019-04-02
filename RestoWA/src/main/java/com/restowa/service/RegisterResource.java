/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.TypeUser;
import com.restowa.domain.model.UserAccount;
import com.restowa.domain.model.Address;
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

/**
 * REST Web Service
 *
 * @author vinceduroc
 */
@Path("Register")
public class RegisterResource {

    @Context
    private UriInfo context;
    
    @Resource
    UserAccountManager uamanager;

    /**
     * Creates a new instance of RegisterResource
     */
    public RegisterResource() {
    }

    /**
     * Retrieves representation of an instance of com.restowa.service.RegisterResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(content);
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
            }
            
            
        catch (ParseException ex) {
            Logger.getLogger(AuthetificationResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject obj = new JSONObject();
        obj.put("message", "Enregistement impossible");
        return obj.toString();
    }

    /**
     * PUT method for updating or creating an instance of RegisterResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
