package com.restowa.service;


import com.restowa.bl.concrete.PromotionManager;
import com.restowa.domain.model.Promotion;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotion")
public class PromotionRestAPI {
    
    @Resource
    PromotionManager promanager;
    
    public PromotionRestAPI()
    {
        
    }
    
    @GetMapping(value = "/getPromotions", produces = MediaType.APPLICATION_JSON)
    public String getJson() {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        List<Promotion> listpromotion= promanager.getAllPromotions();
        
        for(Promotion p : listpromotion)
        {
            JSONObject promotionjson = new JSONObject();
            promotionjson.put("key", p.getKey());
            promotionjson.put("position", p.getPosition());
            promotionjson.put("title", p.getTitle());
            promotionjson.put("shortDesc", p.getShortDescription());
            promotionjson.put("longDesc", p.getLongDescription());
            promotionjson.put("disabled", p.isDisabled());
            promotionjson.put("startDate", p.getStartDate());
            promotionjson.put("endDate", p.getEndDate());
            promotionjson.put("imageURL", p.getImageURL());
            arr.add(promotionjson);
        }
        obj.put("promotions", arr);
        return obj.toString();
    }

    
}
