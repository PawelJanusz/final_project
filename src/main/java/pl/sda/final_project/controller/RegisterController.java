package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.final_project.model.Countries;
import pl.sda.final_project.dto.RegistrationDto;
import pl.sda.final_project.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return registration page from HTML
     */
    @GetMapping("/register") //wpisujemy adres pod jakim pojawi się strona
    public String registrationForm(Model model){
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("countries", Countries.values());  // wyświetla listę krajów
        model.addAttribute("registrationObject",registrationDto); //lista pól z formularza
        return "registrationPage";
    }

    /**
     * @param registrationDto
     * @return redirect on URL login page HTML
     */
    @PostMapping("/register")
    public String registrationEffect(RegistrationDto registrationDto){
        userService.registerUser(registrationDto);
        return "redirect:/login"; //przekierowanie na URL login
    }
}
