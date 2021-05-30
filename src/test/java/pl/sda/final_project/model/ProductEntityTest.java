package pl.sda.final_project.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

    @Test
    void twoObjectsShouldBeEqual(){
        //given
        //when
        ProductEntity productEntity1 = new ProductEntity("Procesor", new BigDecimal(2300), "10 generacja",
                "https://www.google.com/search?q=aorus", ProductType.NOT_FOOD);
        ProductEntity productEntity2 = new ProductEntity("Procesor", new BigDecimal(2300), "10 generacja",
                "https://www.google.com/search?q=aorus", ProductType.NOT_FOOD);
        //then
        assertEquals(productEntity1, productEntity2);
    }

}
