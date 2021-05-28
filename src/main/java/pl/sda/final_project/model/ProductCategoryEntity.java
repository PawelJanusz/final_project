package pl.sda.final_project.model;

import pl.sda.final_project.model.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ProductCategoryEntity extends BaseEntity {

    @NotNull
    private String title;


    public ProductCategoryEntity(String title) {
        this.title = title;
    }

    public ProductCategoryEntity() {
    }

    public String getTitle() {
        return title;
    }
}
