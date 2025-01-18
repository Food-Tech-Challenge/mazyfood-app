package br.com.fiap.ayfood.adapter.in.rest.product;


import br.com.fiap.ayfood.application.port.in.product.CreateProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.DeleteProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.EditProductUseCase;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
public class ManageProductController {
    private final CreateProductUseCase createProductUseCase;
    private final EditProductUseCase editProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ManageProductController(CreateProductUseCase createProductUseCase,
                                   EditProductUseCase editProductUseCase,
                                   DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.editProductUseCase = editProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = createProductUseCase.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(new ProductId(id));
        Product updatedProduct = editProductUseCase.editProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        ProductId productId = new ProductId(id);
        deleteProductUseCase.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
