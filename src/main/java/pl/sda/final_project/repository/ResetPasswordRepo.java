package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.final_project.model.ResetPasswordEntity;

import java.util.Optional;

public interface ResetPasswordRepo extends JpaRepository<ResetPasswordEntity, Long> {


    Optional <ResetPasswordEntity> findByToken(String token);
}
