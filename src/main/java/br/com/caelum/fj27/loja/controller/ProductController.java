package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nando on 02/07/17.
 */
@Controller
public class ProductController {

    @GetMapping("/products/form")
    public String form(){
        return "products/form";
    }

    @PostMapping("/products")
    public String save(Product product){

        System.out.println(product);
        return "products/ok";
    }
}
