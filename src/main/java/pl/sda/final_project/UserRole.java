package pl.sda.final_project;

import javax.persistence.Entity;


@Entity
public class UserRole extends BaseEntity {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }
}
