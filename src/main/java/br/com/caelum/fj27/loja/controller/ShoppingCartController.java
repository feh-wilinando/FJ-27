package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.models.*;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

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

    @Autowired
    private RestTemplate restTemplate;

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


    @PostMapping("/checkout")
    public String checkout(){
        BigDecimal total = shoppingCart.getTotal();

        String uri = "http://book-payment.herokuapp.com/payment";

        try {

            String response = restTemplate.postForObject(uri, new PaymentData(total), String.class);
            System.out.println(response);

            return "redirect:/products";
        }catch (HttpClientErrorException e){
            System.out.println("Ocorreu um erro ao criar o pagamento: " + e.getMessage());

            return "redirect:/shopping";
        }
    }

    @GetMapping
    public String list(){
        return "shoppingCart/items";
    }

}
