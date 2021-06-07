package pl.sda.final_project.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.final_project.model.UserRole;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRoleRepoTest {

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Test
    void addedRoleShouldBeExists(){
        //given
        UserRole userRole = new UserRole("ADMIN");
        //when
        userRoleRepo.save(userRole);
        //then
        assertTrue(userRoleRepo.roleExists("ADMIN"));
    }

    @Test
    void roleShouldBeFindByRoleName(){
        //given
        UserRole userRole = new UserRole("ADMIN");
        //when
        UserRole savedRole = userRoleRepo.save(userRole);
        UserRole findRole = userRoleRepo.findByRoleName("ADMIN");
        //then
        assertEquals(findRole, savedRole);
    }
}
