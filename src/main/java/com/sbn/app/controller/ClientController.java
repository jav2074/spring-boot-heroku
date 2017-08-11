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
@RequestMapping("/client")
public class ClientController 
{
    //##########################################################################
    private ClientRepository clientRepository;
    //##########################################################################

    
    //##########################################################################
    @Autowired
    public ClientController(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String client(ModelMap model) 
    {
        //######################################################################
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("insertClient", new Client());
        //######################################################################
        return "client";
    }
    //##########################################################################
    @RequestMapping(method = RequestMethod.POST)
    public String insertRegClient(ModelMap model, 
                             @ModelAttribute("insertClient") @Valid Client client,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            clientRepository.save(client);
        }
        return client(model);
    }     
    //##########################################################################
    //##########################################################################
}