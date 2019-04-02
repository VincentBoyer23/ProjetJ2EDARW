/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
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
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * REST Web Service
 *
 * @author vinceduroc
 */
@Path("authetification")
public class AuthetificationResource {

    @Context
    private UriInfo context;
    
    @Resource
    UserAccountManager uamanager;

    /**
     * Creates a new instance of AuthetificationResource
     */
    public AuthetificationResource() {
    }

    /**
     * Retrieves representation of an instance of com.restowa.service.AuthetificationResource
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
            System.out.println((String) obj.get("email"));
            List<UserAccount> users = uamanager.getUserAccountByEmailAndPassword((String) obj.get("email"), (String) obj.get("password"));
            System.out.println(users.get(0).getLastname());
            
            if(users.size()!=0)
            {
                obj.put("iduser", users.get(0).getID());
                obj.put("authentificate", true);
                return obj.toString();
            }
            obj.put("authentificate", false);
            return obj.toString();
            
        } catch (ParseException ex) {
            Logger.getLogger(AuthetificationResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject obj = new JSONObject();
        return obj.toString();
    }
    /**
     * PUT method for updating or creating an instance of AuthetificationResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
