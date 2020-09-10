package pl.sda.final_project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.sda.final_project.dto.BasketItemDto;
import pl.sda.final_project.dto.ProductDto;

import java.util.HashSet;
import java.util.Set;

@Service
@SessionScope  // zapisywanie koszyka w sesji, żeby nie zaśmiecac bazy danych po wylogowaniu użytkownika
public class BasketService {

    private final ProductService productService;
    private final Set<BasketItemDto> productList = new HashSet<>();

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    public void addProductToBasket(Long id){
        ProductDto productById = productService.findProductById(id);
        BasketItemDto basketItemDto = new BasketItemDto(1, productById);
        productList.add(basketItemDto);

    }

    public Set<BasketItemDto> getProducts() {
        return productList;
    }
}
