package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import br.com.caelum.fj27.loja.models.ShoppingCart;
import br.com.caelum.fj27.loja.models.ShoppingItem;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nando on 06/07/17.
 */
@Controller
@RequestMapping("shopping")
public class ShoppingCartController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShoppingCart shoppingCart;


    @PostMapping
    public ModelAndView add(Integer productId, @RequestParam BookType bookType){

        ShoppingItem item = createItem(productId, bookType);
        shoppingCart.add(item);

        return new ModelAndView("redirect:/products");
    }

    private ShoppingItem createItem(Integer productId, BookType bookType) {
        Product product = productDao.findOne(productId);

        return new ShoppingItem(product, bookType);
    }

}
