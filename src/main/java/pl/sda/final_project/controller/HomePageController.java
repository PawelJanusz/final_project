package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.service.UserService;
import pl.sda.final_project.service.WeatherService;

@Controller
public class HomePageController {

    private final WeatherService weatherService;
    private final UserService userService;

    public HomePageController(WeatherService weatherService, UserService userService) {
        this.weatherService = weatherService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView showMainWithWeather(){
        double cityTemperature = weatherService.getCityTemperature(userService.getCurrentUser().getUserCity());
        return new ModelAndView("index", "temperature", cityTemperature);
    }


}
