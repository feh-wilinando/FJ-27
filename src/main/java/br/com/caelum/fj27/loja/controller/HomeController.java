package br.com.caelum.fj27.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nando on 02/07/17.
 */
@Controller
public class HomeController {


    @GetMapping("/home")
    public String home(){
        return "index";
    }

}
