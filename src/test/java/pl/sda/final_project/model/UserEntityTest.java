package pl.sda.final_project.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void rolesShouldBeExists(){
        //given
        UserEntity userEntity = new UserEntity();
        //when
        userEntity.addRole(UserRole.apply(UserRole.Roles.USER));
        boolean roleExists = userEntity.roleExists(UserRole.apply(UserRole.Roles.USER));
        //then
        assertTrue(roleExists);
    }

}
