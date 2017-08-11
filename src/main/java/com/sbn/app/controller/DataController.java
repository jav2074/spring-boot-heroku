/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Record;
import com.sbn.app.entity.RecordRepository;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data")
public class DataController 
{
    //##########################################################################
    private RecordRepository repository;
    //##########################################################################

    
    //##########################################################################
    @Autowired
    public DataController(RecordRepository repository)
    {
        this.repository = repository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String data(ModelMap model) 
    {
        //######################################################################
        List<Record> records = repository.findAll();
        model.addAttribute("records", records);
        model.addAttribute("insertRecord", new Record());
        //######################################################################
        return "data";
    }
    //##########################################################################
    @RequestMapping(method = RequestMethod.POST)
    public String insertData(ModelMap model, 
                             @ModelAttribute("insertRecord") @Valid Record record,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            repository.save(record);
        }
        return data(model);
    }    
    //##########################################################################
    //##########################################################################
}
