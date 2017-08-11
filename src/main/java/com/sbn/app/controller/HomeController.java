/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Record;
import com.sbn.app.entity.RecordRepository;
import java.util.List;
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
    private RecordRepository repository;
    
    //##########################################################################
    @Autowired
    public HomeController(RecordRepository repository)
    {
        this.repository = repository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) 
    {
        //######################################################################
        List<Record> records = repository.findAll();
        model.addAttribute("records", records);
//        model.addAttribute("insertRecord", new Record());
        //#####################################################################
        return "home";
    }
    //##########################################################################
    //##########################################################################
}
