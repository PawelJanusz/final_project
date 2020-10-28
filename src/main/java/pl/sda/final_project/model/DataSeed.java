package pl.sda.final_project.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.sda.final_project.repository.ProductCategoryRepo;
import pl.sda.final_project.repository.UserRoleRepo;

@Component
public class DataSeed implements InitializingBean { // poniższa metoda się uruchomi po inicjalizacji springa

    private UserRoleRepo userRoleRepo;
    private ProductCategoryRepo productCategoryRepo;

    public DataSeed(UserRoleRepo userRoleRepo, ProductCategoryRepo productCategoryRepo) {
        this.userRoleRepo = userRoleRepo;
        this.productCategoryRepo = productCategoryRepo;
    }


    @Override
    public void afterPropertiesSet() {
        createRole(UserRole.Roles.ADMIN);
        createRole(UserRole.Roles.USER);
        addCategory(new ProductCategoryEntity("KARTY GRAFICZNE"));
        addCategory(new ProductCategoryEntity("PROCESORY"));
        addCategory(new ProductCategoryEntity("PŁYTY GŁÓWNE"));
        addCategory(new ProductCategoryEntity("PAMIĘĆ RAM"));
        addCategory(new ProductCategoryEntity("ZASILACZE"));
        addCategory(new ProductCategoryEntity("OBUDOWY"));
        addCategory(new ProductCategoryEntity("CHŁODZENIA PROCESORA"));

    }

    private void createRole(UserRole.Roles role) {
        if (!userRoleRepo.roleExists(role.name())) {
            userRoleRepo.save(UserRole.apply(role));
        }
    }

    private void addCategory(ProductCategoryEntity productCategory){
       if (!productCategoryRepo.existsByTitle(productCategory.getTitle())){
           productCategoryRepo.save(productCategory);
       }
    }
}
