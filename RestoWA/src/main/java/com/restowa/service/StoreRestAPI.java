
package com.restowa.service;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.OpeningHours;
import com.restowa.domain.model.Store;
import java.util.Set;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class StoreRestAPI {

    
    @Resource
    StoreManager stmanager;

    public StoreRestAPI() {
    }

    @GetMapping(value = "/getstoreinfo/{idstore}", produces = MediaType.APPLICATION_JSON)
    public String getJson(@PathVariable("idstore") int idstore) {
        JSONObject obj = new JSONObject();
        Store store = stmanager.getStoreById(idstore);
        obj.put("key", store.getKey());
        JSONArray arr = new JSONArray();
        Set<OpeningHours> setopeninghours = store.getOpeninghours();
        
        for(OpeningHours oh : setopeninghours)
        {
            JSONObject openhourjson = new JSONObject();
            openhourjson.put("day", oh.getDay());
            openhourjson.put("from", oh.getFrom());
            openhourjson.put("to", oh.getTo());
            openhourjson.put("close", oh.isClosed());
            openhourjson.put("24h", oh.isAllDay());
            arr.add(openhourjson);
        }
        obj.put("openinghours",arr );
        obj.put("name", store.getName());
        obj.put("phonenumber", store.getPhoneNumber());
        obj.put("email", store.getEmail());
        obj.put("lattitude", store.getLattitude());
        obj.put("longitude", store.getLongitude());
        obj.put("lastmodificationdate", store.getLastModifiedDate());
        obj.put("lastmodificationby", store.getLastModifiedBy().getFirstname());
        obj.put("street", store.getAddress().getStreet());
        obj.put("city", store.getAddress().getCity());
        obj.put("state", store.getAddress().getState());
        obj.put("zipcode", store.getAddress().getZipCode());
        obj.put("Country", store.getAddress().getCountry());
        return obj.toString();
    }

    
}
