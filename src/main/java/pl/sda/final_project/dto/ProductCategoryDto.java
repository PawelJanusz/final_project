package pl.sda.final_project.dto;

import pl.sda.final_project.model.ProductCategoryEntity;

public class ProductCategoryDto {

    private String productCategoryTitle;
    private Long productCategoryId;


    public static ProductCategoryDto apply(ProductCategoryEntity productCategoryEntity) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.productCategoryTitle = productCategoryEntity.getTitle();
        productCategoryDto.productCategoryId = productCategoryEntity.getId();
        return productCategoryDto;
    }

    public String getProductCategoryTitle() {
        return productCategoryTitle;
    }

    public void setProductCategoryTitle(String productCategoryTitle) {
        this.productCategoryTitle = productCategoryTitle;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
