package ufc.managementfighters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {
    
    @GetMapping({"", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("path")
    public String contact() {
        return "contact";
    }

    // @GetMapping(value="/profile")
    // public String profile() {
    //     return "profile";
    // }
    
}
