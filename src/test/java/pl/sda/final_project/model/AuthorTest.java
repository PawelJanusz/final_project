package pl.sda.final_project.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void twoSameObjectsShouldBeNotEqual(){
        //given
        //when
        Author author1 = new Author("Artur", "Malewski");
        Author author2 = new Author("Artur", "Malewski");
        //then
        assertNotSame(author1, author2);
    }

}
