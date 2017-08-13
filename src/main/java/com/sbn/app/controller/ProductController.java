/*
HEROKU - morning-shore-81565
 */
package com.sbn.app.controller;

import com.sbn.app.entity.Product;
import com.sbn.app.entity.ProductRepository;
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
public class ProductController 
{
    //##########################################################################
    private ProductRepository productRepository;
    //##########################################################################

    
    //##########################################################################
    @Autowired
    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    //##########################################################################

    
    //##########################################################################
    @RequestMapping(method = RequestMethod.GET)
    public String client(ModelMap model) 
    {
        //######################################################################
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("insertProduct", new Product());
        //######################################################################
        return "products";
    }
    //##########################################################################
    @RequestMapping(method = RequestMethod.POST)
    public String insertRegClient(ModelMap model, 
                             @ModelAttribute("insertProduct") @Valid Product product,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            productRepository.save(product);
        }
        return client(model);
    }     
    //##########################################################################
    //##########################################################################
}
