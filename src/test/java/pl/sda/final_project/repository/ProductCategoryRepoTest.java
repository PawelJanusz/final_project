package pl.sda.final_project.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.final_project.model.ProductCategoryEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductCategoryRepoTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Test
    void noDataShouldReturnEmptyList(){
        //given
        //when
        List<ProductCategoryEntity> products = productCategoryRepo.findAll();
        //then
        assertEquals(0, products.size());
    }

    @Test
    void saveProductShouldReturnProperOne(){
        //given
        ProductCategoryEntity productCategory = new ProductCategoryEntity("Motherboards");
        //when
        productCategoryRepo.save(productCategory);
        boolean addedProductCategory = productCategoryRepo.existsByTitle("Motherboards");
        //then
        assertTrue(addedProductCategory);
    }

    @Test
    void addedProductCategoryShouldBeSaveToDB(){
        //given
        ProductCategoryEntity productCategory = new ProductCategoryEntity("CPU Cooling");
        //when
        entityManager.persist(productCategory);
        List<ProductCategoryEntity> addedCategory = productCategoryRepo.findAll();
        //then
        assertEquals(1, addedCategory.size());
    }

    @Test
    void addedProductCategoryAbleToDeleteAndReturnEmptyList(){
        //given
        ProductCategoryEntity productCategory = new ProductCategoryEntity("Monitors");
        //when
        entityManager.persist(productCategory);
        productCategoryRepo.deleteAll();
        List<ProductCategoryEntity> addedCategory = productCategoryRepo.findAll();
        //then
        assertEquals(0, addedCategory.size());
    }

}
