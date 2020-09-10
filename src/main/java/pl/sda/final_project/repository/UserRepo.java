package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.final_project.model.UserEntity;

import java.util.Optional;


public interface UserRepo extends JpaRepository<UserEntity, Long> {

    @Query("select case when count(u)> 0 then true else false end from UserEntity u where lower(u.login) like lower(?1) ")
    boolean existsByLogin(String login); // springData sam ułoży zapytanie na podstawie nazwy metody jeśli nie podamy query, co jest nie zalecane, lepiej napisać zapytanie

    @Query("select u from UserEntity u where lower(u.login) = lower(?1)")  // zapytanie w JPQL
    Optional<UserEntity> findByLogin(String login);
}
