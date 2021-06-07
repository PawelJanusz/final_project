package pl.sda.final_project.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.final_project.model.UserEntity;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepo userRepo;

    @Test
    void addedUserShouldBeEqualInDb(){
        //given
        UserEntity user = new UserEntity("Artur", "Kowal", "akowal@wp.pl", "kowal");
        //when
        UserEntity savedUser = userRepo.save(user);
        //then
        assertEquals(user, savedUser);
    }

    @Test
    void addedUserShouldBeExistsByLogin(){
        //given
        UserEntity user = new UserEntity("Pawel", "Nowak", "pnowak@wp.pl", "nowak");
        //when
        userRepo.save(user);
        boolean existsByLogin = userRepo.existsByLogin("pnowak@wp.pl");
        //then
        assertTrue(existsByLogin);
    }

    @Test
    void addedUserShouldReturnOnTheList(){
        //given
        UserEntity user = new UserEntity("Pawel", "Nowak", "pnowak@wp.pl", "nowak");
        //when
        entityManager.persist(user);
        List<UserEntity> addedUser = userRepo.findAll();
        //then
        assertEquals(1, addedUser.size());
    }

    @Test
    void addedUserShouldBeAbleToDeleteAndReturnEmptyList(){
        //given
        UserEntity user = new UserEntity("Pawel", "Nowak", "pnowak@wp.pl", "nowak");
        //when
        entityManager.persist(user);
        userRepo.deleteAll();
        List<UserEntity> addedUser = userRepo.findAll();
        //then
        assertEquals(0, addedUser.size());
    }

}
