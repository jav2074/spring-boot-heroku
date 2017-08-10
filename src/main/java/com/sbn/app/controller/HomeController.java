/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Client;
import com.sbn.app.entity.ClientRepository;
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
@RequestMapping("/")
public class HomeController 
{
    //##########################################################################
    private RecordRepository repository;
    private ClientRepository clientRepository;
    //##########################################################################

    
    //##########################################################################
    @Autowired
    public HomeController(RecordRepository repository, ClientRepository clientRepository)
    {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) 
    {
        //######################################################################
        List<Record> records = repository.findAll();
        model.addAttribute("records", records);
        model.addAttribute("insertRecord", new Record());
        //######################################################################
//        List<Client> clients = clientRepository.findAll();
//        model.addAttribute("client", clients);
//        model.addAttribute("insertClient", new Client());
        //######################################################################
        return "home";
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
        return home(model);
    }    
    //##########################################################################
    @RequestMapping(method = RequestMethod.POST)
    public String insertDBClient(ModelMap model, 
                             @ModelAttribute("insertClient") @Valid Client client,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            clientRepository.save(client);
        }
        return home(model);
    }     
    //##########################################################################
    //##########################################################################
}
