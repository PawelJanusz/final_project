package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.dto.ResetPasswordDto;
import pl.sda.final_project.service.UserService;

@Controller
@RequestMapping("/resetpswd")
public class PasswordController {

    private final UserService userService;

    public PasswordController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ModelAndView resetPassword(){
        return new ModelAndView("resetPage", "resetForm", new ResetPasswordDto());
    }

    @PostMapping
    public String getResetLink(ResetPasswordDto resetPasswordDto){
        userService.sendResetLink(resetPasswordDto);
        return "loginPage";
    }


}
