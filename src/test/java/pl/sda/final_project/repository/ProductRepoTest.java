package pl.sda.final_project.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.final_project.model.ProductEntity;
import pl.sda.final_project.model.ProductType;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductRepoTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductRepo productRepo;

    @Test
    void noDataShouldReturnEmptyList(){
        //given
        //when
        List<ProductEntity> product = productRepo.findAll();
        //then
        assertEquals(0, product.size());
    }

    @Test
    void saveProductsShouldReturnOnTheList(){
        //given
        ProductEntity product1 = new ProductEntity("Graphic card", new BigDecimal(4500),"With WB block",
                "https://www.google.com/search?q=aorus", ProductType.NOT_FOOD);
        //when
        productRepo.save(product1);
        ProductEntity addedProduct = productRepo.findByTitle("Graphic card").orElse(null);
        //then
        assertEquals(product1, addedProduct);
    }
}
