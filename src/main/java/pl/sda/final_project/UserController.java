package pl.sda.final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {



    @GetMapping("/register") //wpisujemy adres pod jakim pojawi się strona
    public String registrationForm(Model model){
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("countries",Countries.values());  // wyświetla listę krajów
        model.addAttribute("registrationObject",registrationDto); //lista pól z formularza
        return "registrationPage";
    }

    @PostMapping("/register")
    public String registrationEffect(RegistrationDto registrationDto){
        return "redirect:/login"; //przekierowanie na URL login
    }
}
