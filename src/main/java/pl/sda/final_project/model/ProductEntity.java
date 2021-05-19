package pl.sda.final_project.model;


import pl.sda.final_project.dto.ProductDto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class ProductEntity extends BaseEntity {

    private String title;
    private String description;
    private String imageUrl;

    @ManyToOne
    private ProductCategoryEntity category;
    private BigDecimal price;   // nie może być Double ani Integer ani Float
    private ProductType productType;

    @Embedded
    private Author author;

    public ProductEntity(String title, String description, ProductType productType) {
        this.title = title;
        this.description = description;
        this.productType = productType;
    }

    public ProductEntity() {
    }

    public static ProductEntity apply(ProductDto productDto) {
        ProductEntity productEntityToSave = new ProductEntity();
        productEntityToSave.title = productDto.getProductTitle();
        productEntityToSave.description = productDto.getProductDescription();
        productEntityToSave.imageUrl = productDto.getProductImageUrl();
        productEntityToSave.price = productDto.getProductPrice();
        productEntityToSave.author = Author.apply(productDto);
        productEntityToSave.productType = ProductType.valueOf(productDto.getProductType());

        return productEntityToSave;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEntity category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
