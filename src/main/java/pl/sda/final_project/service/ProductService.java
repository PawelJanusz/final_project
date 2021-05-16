package pl.sda.final_project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sda.final_project.model.ProductCategoryEntity;
import pl.sda.final_project.model.ProductEntity;
import pl.sda.final_project.dto.ProductDto;
import pl.sda.final_project.repository.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductCategoryService productCategoryService;

    public ProductService(ProductRepo productRepo, ProductCategoryService productCategoryService) {
        this.productRepo = productRepo;
        this.productCategoryService = productCategoryService;
    }

    public void saveProduct(ProductDto productDto){
       ProductEntity productEntityToSave = ProductEntity.apply(productDto);
       ProductCategoryEntity category = productCategoryService.findCategoryById(productDto.getProductCategory().getProductCategoryId())
                .orElseThrow(() -> new RuntimeException("Can,t find category"));
       productEntityToSave.setCategory(category);
       productRepo.save(productEntityToSave);
    }
    //rozpoznaje podane w parametrach (?page=0&size=10)
    public Page<ProductDto> findProducts(Pageable pageable) {  // pobieranie listy produktów
        Page<ProductEntity> page = productRepo.findAll(pageable);
        List<ProductDto> collect = page.stream()
                .map(ProductDto::apply)
                .collect(Collectors.toList());
       return new PageImpl<>(collect, pageable, page.getTotalElements());

    }

    public ProductDto findProductById(Long id) {
        return productRepo.findById(id)
                .map(ProductDto::apply)
                .orElseThrow(() -> new RuntimeException("Blow up in ProductService"));
    }
}
