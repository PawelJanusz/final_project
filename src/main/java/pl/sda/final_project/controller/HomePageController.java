package pl.sda.final_project.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.service.UserService;
import pl.sda.final_project.service.WeatherService;

import java.util.HashMap;
import java.util.Map;


@Controller
public class HomePageController {

    private final WeatherService weatherService;
    private final UserService userService;

    public HomePageController(WeatherService weatherService, UserService userService) {
        this.weatherService = weatherService;
        this.userService = userService;
    }

    /**
     * @return HTML main page with actual temperature and humidity
     */
    @GetMapping("/")
    public ModelAndView showMainWithWeather(){
        Map<String, ModelAndView> mapModel = new HashMap<>();
        double cityTemperature = weatherService.getCityTemperature(userService.getCurrentUser().getUserCity());
        double cityHumidity = weatherService.getHumidity(userService.getCurrentUser().getUserCity());

        mapModel.put("temperature", new ModelAndView("index", "temperature", cityTemperature));
        mapModel.put("humidity", new ModelAndView("index", "humidity", cityHumidity));

        return new ModelAndView("index","weather", mapModel);
    }


//    @GetMapping
//    public ModelAndView showMainWithHumidity(){
//        double cityHumidity = weatherService.getHumidityTemperature(userService.getCurrentUser().getUserCity());
//        return new ModelAndView("index", "clouds", cityHumidity);
//    }


}
