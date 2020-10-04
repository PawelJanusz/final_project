package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.dto.ChangePasswordDto;
import pl.sda.final_project.service.UserService;

@Controller
@RequestMapping("/reset")
public class ChangePasswordController {

    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{token}")
    public ModelAndView getChangePasswordForm(@PathVariable String token){
        ChangePasswordDto modelObject = new ChangePasswordDto();
        modelObject.setToken(token);

        return new ModelAndView("changePassword", "changePassword", modelObject);

    }

    @PostMapping
    public String changePassword(ChangePasswordDto changePasswordDto){
        userService.changePassword(changePasswordDto);

        return "redirect:/login";
    }
}
