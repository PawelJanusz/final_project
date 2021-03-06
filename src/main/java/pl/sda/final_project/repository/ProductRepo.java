package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.final_project.model.ProductEntity;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    /**
     *Spring Data can search by method name
     */
    Optional<ProductEntity> findByTitle(String title);
}
