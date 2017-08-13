/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Client;
import com.sbn.app.entity.ClientRepository;
import com.sbn.app.entity.Product;
import com.sbn.app.entity.ProductRepository;

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
    private ClientRepository clientRepository;
    private ProductRepository productRepository;
    //##########################################################################
    
    //##########################################################################
    @Autowired
    public HomeController(  ClientRepository clientRepository, 
                            ProductRepository productRepository )
    {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) 
    {
        //######################################################################
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        //######################################################################
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        //######################################################################
        return "home";
    }
    //##########################################################################
    //##########################################################################
}
