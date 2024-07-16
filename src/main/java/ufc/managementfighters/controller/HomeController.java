package ufc.managementfighters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



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
}
