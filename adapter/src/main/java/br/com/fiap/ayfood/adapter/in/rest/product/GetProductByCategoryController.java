package br.com.fiap.ayfood.adapter.in.rest.product;

import br.com.fiap.ayfood.application.port.in.product.CategoryNotFoundException;
import br.com.fiap.ayfood.application.port.in.product.GetProductByCategoryUseCase;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")

public class GetProductByCategoryController {

    private final GetProductByCategoryUseCase getProductByCategoryUseCase;

    public GetProductByCategoryController(GetProductByCategoryUseCase getProductByCategoryUseCase) {
        this.getProductByCategoryUseCase = getProductByCategoryUseCase;
    }

    @GetMapping
    public List<ProductInListWebModel> getProductByCategory(@RequestParam(value = "category", required = true) String categoryString) {
        Category category = Category.valueOf(categoryString.toUpperCase());
        List<Product> products;

        try {
            products = getProductByCategoryUseCase.filterProductByCategory(category);
        } catch (IllegalArgumentException e) {
            throw new CategoryNotFoundException("Category '" + category + "' not found.");
        }

        return products.stream().map(ProductInListWebModel::fromDomainModel).toList();
    }
}

