package pl.sda.final_project.model;

import pl.sda.final_project.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ProductCategoryEntity extends BaseEntity {

    private String title;

    // konstruktor domyślny bezparametrowy

    public String getTitle() {
        return title;
    }

    public ProductCategoryEntity(String title) {
        this.title = title;
    }

    public ProductCategoryEntity() {
    }


}
