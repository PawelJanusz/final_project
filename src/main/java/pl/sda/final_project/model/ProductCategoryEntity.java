package pl.sda.final_project.model;

import pl.sda.final_project.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ProductCategoryEntity extends BaseEntity {

    private String title;


    /**
     * default constructor without parameters
     */
    public String getTitle() {
        return title;
    }

    public ProductCategoryEntity(String title) {
        this.title = title;
    }

    public ProductCategoryEntity() {
    }


}
