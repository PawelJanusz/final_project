package pl.sda.final_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.final_project.weather.FullWhetherInfo;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    @Value(value = "${weather.api-key}")
    private String openWeatherKey;


    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getCityTemperature(String city) {

        String basicWeatherTemplate = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";
        String fullURL = String.format(basicWeatherTemplate, city, openWeatherKey);

        FullWhetherInfo whether = restTemplate.getForObject(fullURL, FullWhetherInfo.class);
        return whether.getMain().getTemp();

    }

}
