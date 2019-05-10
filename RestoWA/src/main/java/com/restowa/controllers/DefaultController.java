
package com.restowa.controllers;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    private final Logger logger = Logger.getLogger(DefaultController.class);
            
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
       logger.info("start Home page");
        return "index";
    }
    
}
