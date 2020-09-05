package pl.sda.final_project.service;

import org.springframework.stereotype.Service;
import pl.sda.final_project.dto.ProductCategoryDto;
import pl.sda.final_project.model.ProductCategoryEntity;
import pl.sda.final_project.dto.ProductDto;
import pl.sda.final_project.repository.ProductCategoryRepo;
import pl.sda.final_project.repository.ProductRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepo productCategoryRepo;

    public ProductCategoryService(ProductCategoryRepo productCategoryRepo) {
        this.productCategoryRepo = productCategoryRepo;
    }

    public List<ProductCategoryDto> findProductCategory(){
        return productCategoryRepo.findAll().stream()
                .map(ProductCategoryDto::apply)
                .collect(Collectors.toList());
    }

    public Optional<ProductCategoryEntity> findCategoryById(Long id){
        return productCategoryRepo.findById(id);

    }
}
