package pl.sda.final_project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.sda.final_project.dto.BasketItemDto;
import pl.sda.final_project.dto.ProductDto;

import java.util.*;

@Service
@SessionScope  // zapisywanie koszyka w sesji, żeby nie zaśmiecac bazy danych po wylogowaniu użytkownika
public class BasketService {

    private final ProductService productService;
    private final Map<Long, BasketItemDto> products = new HashMap<>();

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    public void addProductToBasket(Long id){
        ProductDto productById = productService.findProductById(id);
        BasketItemDto basketItemDto = new BasketItemDto(1, productById);
        if (products.containsKey(id)) {
            BasketItemDto basketItem = products.get(id);
            Integer amount = basketItem.getAmount();
            basketItem.setAmount(amount + 1);
        }else {
            products.put(id, basketItemDto);
        }

    }

    public Collection<BasketItemDto> getProducts() {
        return products.values();
    }

//    private void findProductInBasket(BasketItemDto basketItemDto) {
//        Long itemDto = basketItemDto.getProductDto().getId();
//        if (products.containsKey(itemDto)) {
//            BasketItemDto basketItem = products.get(itemDto);
//            Integer amount = basketItem.getAmount();
//            basketItem.setAmount(amount + 1);
//        }
//    }
}
