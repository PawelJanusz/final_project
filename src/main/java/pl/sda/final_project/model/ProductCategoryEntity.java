package pl.sda.final_project.model;

import pl.sda.final_project.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ProductCategoryEntity extends BaseEntity {

    private String title;


    public ProductCategoryEntity(String title) {
        this.title = title;
    }
    /**
     * default constructor without parameters
     */
    public ProductCategoryEntity() {
    }

    public String getTitle() {
        return title;
    }
}
