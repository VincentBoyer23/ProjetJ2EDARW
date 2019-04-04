/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.UserAccount;
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
import javax.annotation.Resource;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Service
 *
 * @author vinceduroc
 */
@Path("Getstoreinfo")
public class GetstoreinfoResource {

    @Context
    private UriInfo context;
    
    @Resource
    StoreManager stmanager;

    /**
     * Creates a new instance of GetstoreinfoResource
     */
    public GetstoreinfoResource() {
    }

    /**
     * Retrieves representation of an instance of com.restowa.service.GetstoreinfoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{idstore}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idstore") int idstore) {
        JSONObject obj = new JSONObject();
        Store store = stmanager.getStoreById(idstore);
        obj.put("key", store.getKey());
        /*savoir ce dont il a besoin en interface pour ne pas renvoyer la liste des heures d'ouverture*/

        obj.put("openinghours", store.getOpeninghours());
        obj.put("name", store.getName());
        obj.put("phonenumber", store.getPhoneNumber());
        obj.put("email", store.getEmail());
        obj.put("lattitude", store.getLattitude());
        obj.put("longitude", store.getLongitude());
        obj.put("lastmodificationdate", store.getLastModifiedDate());
        /*savoir ce dont il a besoin en interface pour ne pas renvoyer un utilisateur entier*/
        obj.put("lastmodificationby", store.getLastModifiedBy());
        obj.put("street", store.getAddress().getStreet());
        obj.put("city", store.getAddress().getCity());
        obj.put("state", store.getAddress().getState());
        obj.put("zipcode", store.getAddress().getZipCode());
        obj.put("Country", store.getAddress().getCountry());
        return obj.toString();
    }

    /**
     * PUT method for updating or creating an instance of GetstoreinfoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
