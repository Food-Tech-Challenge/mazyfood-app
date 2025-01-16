package br.com.fiap.ayfood.application.port.in.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;

import java.util.List;

public interface GetProductByCategoryUseCase {

    List<Product> filterProductByCategory(Category category);
}
