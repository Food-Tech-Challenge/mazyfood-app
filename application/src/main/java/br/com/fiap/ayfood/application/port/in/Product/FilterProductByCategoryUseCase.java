package br.com.fiap.ayfood.application.port.in.Product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;

import java.util.List;

public interface FilterProductByCategoryUseCase {

    List<Product> filterProductByCategory(Category category);
}
