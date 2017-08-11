/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController 
{
    //##########################################################################

    
    //##########################################################################
    @Autowired
    public HomeController()
    {
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) 
    {
        return "home";
    }
    //##########################################################################
    //##########################################################################
}
