package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.final_project.model.ProductCategoryEntity;

import java.util.Optional;

public interface ProductCategoryRepo extends JpaRepository<ProductCategoryEntity, Long> {

    @Query("select case when count(pc)> 0 then true else false end from ProductCategoryEntity pc where lower(pc.title) like lower(?1)") //TODO zmiana
    boolean existsByTitle(String title);

}
