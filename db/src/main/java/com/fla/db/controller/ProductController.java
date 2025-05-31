package com.fla.db.controller;

import com.fla.db.model.Product;
import com.fla.db.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller, handling HTTP requests/responses
@RequestMapping("/products") // Base URL for all endpoints in this controller
public class ProductController {

    private final ProductService productService;

    @Autowired // Injects the ProductService dependency
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // Handles GET requests to /products
    public List<Product> getProducts() {
        return productService.getProducts(); // Returns a list of all products
    }

    @GetMapping("/{id}") // Handles GET requests to /products/{id}
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id); // Retrieves a product by its ID
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @PostMapping // Handles POST requests to /products
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}") // Handles PUT requests to /products/{id}
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
         Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

     @DeleteMapping("/{id}") // Handles DELETE requests to /products/{id}
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /* Search and Filter Functions */
    @GetMapping("/search-by-category") // Handles GET requests to /products
    public List<Product> getProductsByCategory(@RequestParam String searchTerm) {
        return productService.getProductsByCategoryOrderByTitle(searchTerm); // Returns a list of all products
    }

    @GetMapping("/search")
    public List<Product> getProductsByTitle(@RequestParam String searchTerm) {
        return productService.getProductsByTitle(searchTerm); // Returns a list of all products
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPrice(@RequestParam int startPrice, @RequestParam int endPrice) {
        return productService.getProductsByPrice(startPrice, endPrice); // Returns a list of all products
    }

}