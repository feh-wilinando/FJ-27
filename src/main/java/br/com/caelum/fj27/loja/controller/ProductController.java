package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

/**
 * Created by nando on 02/07/17.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products/form")
    public ModelAndView form(){
        ModelAndView view = new ModelAndView("products/form");

        view.addObject("types", BookType.values());

        return view;
    }

    @GetMapping("/products")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("products/list");

        view.addObject("products", productDao.list());

        return view;
    }

    @PostMapping("/products")
    @Transactional
    public String save(Product product){

        productDao.save(product);

        return "products/ok";
    }
}
