package ufc.managementfighters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import ufc.managementfighters.model.RegisterDto;
import ufc.managementfighters.repository.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Controller works with Thymeleaf if not you have to put the Rest Controller to debug the White label error page so you have to install the dependenie Thymeleaf 
 */
@Controller
public class AccountController {
    

    @Autowired
    private AppUserRepository repo;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();

        model.addAttribute(registerDto);

        return "register";
    }
    
}
