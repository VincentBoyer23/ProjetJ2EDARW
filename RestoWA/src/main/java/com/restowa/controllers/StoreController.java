package com.restowa.controllers;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import java.util.Date;
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
public class StoreController {
    @Resource
    StoreManager smanager;
            
    private final Logger logger = Logger.getLogger(StoreController.class);

    
    @RequestMapping(value = "/store/{id}", method = RequestMethod.GET)
    public String storeEdit(@PathVariable("id") int id,ModelMap map){
        logger.info("start store update");
        Store s = smanager.getStoreById(id);
        map.addAttribute("storeform", s );
        map.addAttribute("storeModif", true);
        logger.info("end store update");
        return "index";
    }
    
        @RequestMapping(value = "/store/add", method = RequestMethod.GET)
    public String storeAdd(ModelMap map){
        logger.info("start store create");
        Store s = new Store();
        map.addAttribute("storeform", s );
        map.addAttribute("storeAdd", true);
        logger.info("end store create");
        return "index";
    }
    
            @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public String stores(@RequestParam(required = false) String q,ModelMap map){
        logger.info("start listing stores");
                if (q!= null && q!= "") {
                    List<Store> stores = smanager.getStoresByKeywords(q);
                    map.addAttribute("stores", stores );
                    map.addAttribute("storesList", true);
                    logger.info("end listing stores");
                    return "index";
                }
                else{
                    List<Store> stores = smanager.getAllStore();
                    map.addAttribute("stores", stores );
                    map.addAttribute("storesList", true);
                    logger.info("end listing stores");
                    return "index";
                }

    }
    
    @RequestMapping(value= "/store/add", method= RequestMethod.POST)
    public String insertStore(@Valid @ModelAttribute("storeform") Store store, BindingResult result,ModelMap map) {
        logger.info("start store create");
        if (result.hasErrors()) {
            return "./store/add";
        }
        else{
            store.setLastModifiedDate(new Date());
            int idUser = smanager.insertStore(store);
                map.addAttribute("success",true);
                map.addAttribute("titre","Création");
                map.addAttribute("message","Le magasin a bien été créer");
            logger.info("end store create");
                
            return "index";
        }
    }
    
    @RequestMapping(value = "/store/{id}", method = RequestMethod.POST)
        public String saveStore(@PathVariable("id") int id,@Valid @ModelAttribute("storeform") Store store, BindingResult result,ModelMap map) {
            logger.info("start store update");
            if (result.hasErrors()) {
                logger.info("end store update");
                return "./store/"+id;
                
            }
            else{
                store.setID(id);
                map.addAttribute("success",true);
                map.addAttribute("titre","Mise à jour");
                map.addAttribute("message","Le magasin a bien été mis à jour");
                
                
                smanager.updateStore(store);
                logger.info("end store update");
                return "index";
            }
        }
        
    @RequestMapping (value = "/store/delete/{id}", method = RequestMethod.POST)
        public String deleteStore(@PathVariable("id") int id,ModelMap map){
            logger.info("start store delete");
            Store s = smanager.getStoreById(id);
            smanager.deleteStore(s);
            map.addAttribute("success",true);
            map.addAttribute("titre","Suppresion");
            map.addAttribute("message","Le magasin a bien été supprimer");
            logger.info("end store delete");
            return "index";
        }
        
    
}
