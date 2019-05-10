/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.PromotionManager;
import com.restowa.domain.model.Promotion;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class PromotionController {
    @Resource
    PromotionManager pmanager;
    
    private final Logger logger = Logger.getLogger(PromotionController.class);
    
    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.GET)
    public String promotionEdit(@PathVariable("id") int id,ModelMap map){
        logger.info("start promotion update");
        Promotion p = pmanager.getPromotionById(id);
        map.addAttribute("promotionform", p);
        map.addAttribute("promotionModif", true);
        logger.info("end promotion update");
        return "index";
    }
    
    @RequestMapping(value = "/promotion/add", method = RequestMethod.GET)
    public String promotionAdd(ModelMap map){
        logger.info("start promotion insert");
        Promotion p = new Promotion();
        map.addAttribute("promotionform", p);
        map.addAttribute("promotionAdd", true);
        logger.info("end promotion update");
        return "index";
    }
    
    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    public String promotions(@RequestParam(required = false) String q,ModelMap map){
        logger.info("start promotion listing");
        if (q!= null && q!= "") {
                    List<Promotion> promotions = pmanager.getPromotionsByWord(q);
                    map.addAttribute("promotions", promotions );
                    map.addAttribute("promotionsList", true);
                    logger.info("end promotion listing");
                    return "index";
                }
                else{
                    List<Promotion> promotions = pmanager.getAllPromotions();
                    map.addAttribute("promotions", promotions );
                    map.addAttribute("promotionsList", true);
                    logger.info("end promotion listing");
                    return "index";
                }
    }
    
    @RequestMapping(value= "/promotion/add", method= RequestMethod.POST)
    public String insertStore(@Valid @ModelAttribute("promotionform") Promotion promotion, BindingResult result,ModelMap map) {
        logger.info("start promotion insert");
        if (result.hasErrors()) {
            return "./promotion/add";
        }
        else{
            int idPromo = pmanager.inserPromotion(promotion);
                map.addAttribute("success",true);
                map.addAttribute("titre","Création");
                map.addAttribute("message","La promotion a bien été créer.");
                logger.info("end promotion insert");
            return "index";
        }
    }
    
     @RequestMapping(value = "/promotion/{id}", method = RequestMethod.POST)
        public String savePromotion(@PathVariable("id") int id,@Valid @ModelAttribute("promotionform") Promotion promotion, BindingResult result, ModelMap map) {
            logger.info("start promotion update");
            if (result.hasErrors()) {
                logger.info("end promotion update");
                return "./promotion/"+id;
            }
            else{
                promotion.setId(id);
                
                pmanager.updatePromotion(promotion);
                map.addAttribute("success",true);
                map.addAttribute("titre","Modification");
                map.addAttribute("message","La promotion a bien été mise à jour");
                logger.info("end promotion update");
                return "index";
            }
        }
        
        @RequestMapping (value = "/promotion/delete/{id}", method = RequestMethod.POST)
        public String deletePromotion(@PathVariable("id") int id,ModelMap map){
            logger.info("start promotion delete");
            Promotion p = pmanager.getPromotionById(id);
            pmanager.deletePromotion(p);
                map.addAttribute("success",true);
                map.addAttribute("titre","Suppresion");
                map.addAttribute("message","La promotion a bien été supprimer");
                logger.info("start promotion delete");
                
            return "index";
        }
}