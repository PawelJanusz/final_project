package pl.sda.final_project.dto;

import pl.sda.final_project.dto.ProductDto;

import java.util.Objects;

public class BasketItemDto {

    private Integer amount;
    private ProductDto productDto;

    public BasketItemDto(Integer amount, ProductDto productDto) {
        this.amount = amount;
        this.productDto = productDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItemDto that = (BasketItemDto) o;
        return Objects.equals(productDto, that.productDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productDto);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
