package ufc.managementfighters.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ufc.managementfighters.model.AppUser;
import ufc.managementfighters.model.RegisterDto;
import ufc.managementfighters.repository.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.validation.Valid;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;




/*
 * Controller works with Thymeleaf if not you have to put the Rest Controller to debug the White label error page so you have to install the dependenie Thymeleaf 
 * This class also is the file to render dynamically with Thymeleaf 
 */
@Controller
public class AccountController {


    private final AppUserRepository repo;
    

    public AccountController(AppUserRepository repo){
        
        this.repo = repo;

    }


    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();

        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "register";
    }



    @GetMapping("/profile")
        public String getUserProfile(@RequestParam(required = true) String email, Model model){
            
            System.out.println("L'email est  :" + email);
            AppUser user = repo.findByEmail(email);
            System.out.println("the email is :" + email);
            if(user != null){
                model.addAttribute("user", user);
            }else{
                model.addAttribute("error", "User not found");
            }

            return "profile";
        }
    
    
   
    @PostMapping("/register")
    public String register(
        Model model, 
        @Valid @ModelAttribute RegisterDto registerDto,
        BindingResult result
        ){
            // Handling authentification errors if its equals to the Password field and Confirm password are different 
            if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
                result.addError(
                    new FieldError("registerDto", "confirmPassword"
                    , "Password and confirm password do not match")
                );
            }

            AppUser appUser = repo.findByEmail(registerDto.getEmail());
            if(appUser != null){
                result.addError(
                    new FieldError("registerDto","email"
                    ,"Email adress is already used")
                );
            }

            if(result.hasErrors()){
                return "register";
            }

            // User account creation in a try catch block
            
            try {

                // Hash password
                var bCryptEncoder = new BCryptPasswordEncoder();

                AppUser newUser = new AppUser();
                newUser.setFirstName(registerDto.getFirstName());
                newUser.setLastName(registerDto.getLastName());
                newUser.setEmail(registerDto.getEmail());
                newUser.setPhone(registerDto.getPhone());
                newUser.setRole("client");
                newUser.setCreatedAt(new Date());
                newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

                repo.save(newUser);

                model.addAttribute("registerDto", new RegisterDto());
                model.addAttribute("success", true);

            } catch (Exception e) {

                result.addError(
                    new FieldError("registerDto", "firstname"
                    , e.getMessage())
                );

            }
            return "register";
        }
}
