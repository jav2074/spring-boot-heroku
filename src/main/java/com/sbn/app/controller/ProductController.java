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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/product")
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
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(ModelMap model) 
    {
        //######################################################################
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("insertProduct", new Product());
        //######################################################################
        return "product";
    }
    //##########################################################################
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String insertProduct(ModelMap model, 
                             @ModelAttribute("insertProduct") @Valid Product product,
                             BindingResult result) 
    {
        if (!result.hasErrors()) 
        {
            productRepository.save(product);
        }
        return product(model);
    }     
    //##########################################################################
    //##########################################################################
    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public String updateProduct( ModelMap model, 
                                @RequestParam("id_reg") String strID) 
    {
        //######################################################################
        Product product = productRepository.findOne(Long.parseLong(strID));
        model.addAttribute("product", product);
        //######################################################################
        return "product_update";
    }
    //##########################################################################
    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    public String deleteProduct( ModelMap model, 
                                @RequestParam("id_reg") String strID) 
    {
            productRepository.delete(Long.parseLong(strID));
        return product(model);
    }
    //##########################################################################
}
