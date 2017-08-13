/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Client;
import com.sbn.app.entity.ClientRepository;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/client")
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
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String client(ModelMap model) 
    {
        //######################################################################
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("insertClient", new Client());
        //######################################################################
        return "client";
    }
    //##########################################################################
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String insertRegClient(ModelMap model, 
                             @ModelAttribute("insertClient") @Valid Client client,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            clientRepository.save(client);  // saveOrUpdate / save / saveAndFlush
        }
        return client(model);
    }     
    //##########################################################################
    //##########################################################################
    @RequestMapping(value = "/client/update", method = RequestMethod.POST)
    public String updateClient( ModelMap model, 
                                @RequestParam("id_reg") String strID) 
    {
        //######################################################################
        Client client = clientRepository.findOne(Long.parseLong(strID));
        model.addAttribute("client", client);
//        model.addAttribute("insertClient", new Client());
        //######################################################################
        return "client_update";
    }
    //##########################################################################
    @RequestMapping(value = "/client/delete", method = RequestMethod.POST)
    public String deleteClient( ModelMap model, 
                                @RequestParam("id_reg") String strID) 
    {
            clientRepository.delete(Long.parseLong(strID));
        return client(model);
    }
    //##########################################################################
}
