package pl.sda.final_project;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DataSeed implements InitializingBean { // poniższa metoda się uruchomi po inicjalizacji springa

    private UserRoleRepo userRoleRepo;

    public DataSeed(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }


    @Override
    public void afterPropertiesSet() {
        createRole(UserRole.Roles.ADMIN);
        createRole(UserRole.Roles.USER);
    }

    private void createRole(UserRole.Roles role) {
        if (!userRoleRepo.roleExists(role.name())) {
            userRoleRepo.save(UserRole.apply(role));
        }
    }

}
