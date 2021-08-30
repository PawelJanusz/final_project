package pl.sda.final_project.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketItemDtoTest {

    @Test
    void objectsShouldNotBeEqual(){
        //given
        ProductDto productDto1 = new ProductDto("Obudowa", "Corsair", "Ninja");
        ProductDto productDto2 = new ProductDto("Obudowa", "Enermax", "Ninja");
        //when
        BasketItemDto basketItemDto1 = new BasketItemDto(2, productDto1);
        BasketItemDto basketItemDto2 = new BasketItemDto(2, productDto2);
        //then
        assertNotSame(basketItemDto1, basketItemDto2);


    }

}
