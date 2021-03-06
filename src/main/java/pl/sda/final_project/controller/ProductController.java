package pl.sda.final_project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.service.ProductCategoryService;
import pl.sda.final_project.dto.ProductDto;
import pl.sda.final_project.service.ProductService;
import pl.sda.final_project.model.ProductType;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;


    public ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }


    @GetMapping("/all")
    public ModelAndView getProducts(Pageable pageable){ //Pageable - klasa odpowiada za paginację
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", productService.findProducts(pageable));
        return modelAndView;
    }

    /**
     * @return template form to add product
     */
    @GetMapping("/add")
    public ModelAndView saveProductForm(){
        ModelAndView modelAndView = new ModelAndView("productAdd");
        ProductDto productDto = new ProductDto();
        modelAndView.addObject("productToSave", productDto);
        modelAndView.addObject("productTypes", ProductType.values());
        modelAndView.addObject("productCategories", productCategoryService.findProductCategory());

        return modelAndView;
    }

    /**
     * @return redirect to page with all added products
     */
    @PostMapping("/add")
    public String saveProduct(@Valid ProductDto productDto){
        productService.saveProduct(productDto);
        return "redirect:/product/all";
    }
}
