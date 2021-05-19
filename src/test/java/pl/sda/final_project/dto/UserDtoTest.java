package pl.sda.final_project.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void objectsShouldBeEqual(){
        //given
        //when
        UserDto userDto1 = new UserDto("Ola", "Wrocław");
        UserDto userDto2 = new UserDto("Ola", "Wrocław");
        //then
        assertEquals(userDto1, userDto2);
    }

}
