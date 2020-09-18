package pl.sda.final_project.rest;

import org.springframework.web.bind.annotation.*;
import pl.sda.final_project.dto.BasketItemDto;
import pl.sda.final_project.service.BasketService;

import java.util.Collection;

@RestController
@RequestMapping("/basket")
public class BasketRestController {

    private final BasketService basketService;

    public BasketRestController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/{id}")
    public void addToBasket(@PathVariable Long id){
        basketService.addProductToBasket(id);
    }

    @GetMapping()
    public Collection<BasketItemDto> showBasket(){
        return basketService.getProducts();
    }

}
