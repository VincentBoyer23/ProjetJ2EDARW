/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author vinceduroc
 */
@Path("Getuserinfo")
public class GetuserinfoResource {

    @Context
    private UriInfo context;
    
    @Resource
    UserAccountManager uamanager;

    /**
     * Creates a new instance of GetuserinfoResource
     */
    public GetuserinfoResource() {
    }

    /**
     * Retrieves representation of an instance of com.restowa.service.GetuserinfoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{iduser}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("iduser") int iduser) {
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

    /**
     * PUT method for updating or creating an instance of GetuserinfoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
