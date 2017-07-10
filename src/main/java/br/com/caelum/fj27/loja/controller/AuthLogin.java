package br.com.caelum.fj27.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nando on 10/07/17.
 */
@Controller
public class AuthLogin {

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }
}
