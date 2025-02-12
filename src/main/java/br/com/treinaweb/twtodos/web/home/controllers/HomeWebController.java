package br.com.treinaweb.twtodos.web.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeWebController {

    @GetMapping
    public String index() {
        return "redirect:/todos";
    }
    
}
