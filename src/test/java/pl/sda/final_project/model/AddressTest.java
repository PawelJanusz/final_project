package pl.sda.final_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void addressShouldBeEqual(){
        //given
        //when
        Address address1 = new Address("Legnica", "55-220", Countries.POLAND, "Piastowska");
        Address address2 = new Address("Legnica", "55-220", Countries.POLAND, "Piastowska");

        //then
        assertEquals(address1, address2);
    }
}
