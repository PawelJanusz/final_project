package pl.sda.final_project.dto;

import pl.sda.final_project.model.ProductEntity;

import java.math.BigDecimal;

public class ProductDto {

    private String productTitle;
    private String productDescription;
    private String productImageUrl;

    private Long productCategoryId;
    private String productCategoryTitle;
    private BigDecimal productPrice;
    private String productType;
    private String authorName;
    private String authorSurname;



    public static ProductDto apply(ProductEntity productEntity){
        ProductDto productDto = new ProductDto();
        productDto.setProductTitle(productEntity.getTitle());
        productDto.setProductDescription(productEntity.getDescription());
        productDto.setProductCategoryId(productEntity.getCategory().getId());
        productDto.setProductType(productEntity.getProductType().getPlName());
        productDto.setProductPrice(productEntity.getPrice());
        productDto.setAuthorName(productEntity.getAuthor().getAuthorName());
        productDto.setAuthorSurname(productEntity.getAuthor().getAuthorSurname());

        return productDto;
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

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }



    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }



    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}
