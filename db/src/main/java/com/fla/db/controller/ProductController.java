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
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        else {
//            return ResponseEntity.status(HttpStatus.OK).body(product);
            return ResponseEntity.ok(product);
        }
    }



    @PostMapping // Handles POST requests to /products
    public Product createProduct(@RequestBody Product product) {
        // TODO - Return HttpStatus.CREATED when successful else HttpStatus.BAD_REQUEST
        // If the product is successfully created, it will return a 201 Created status
        // If there is an error in creating the product, it will return a 400 Bad Request status
        // Note: The service method should handle the logic for creation and return appropriate response.
        // Return type of this function should be ResponseEntity<Product> to indicate success or failure
        return productService.createProduct(product); // Creates a new product from the request body
    }

    @PutMapping("/{id}") // Handles PUT requests to /products/{id}
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // TODO - Return HttpStatus.OK when successful else HttpStatus.NOT_FOUND
        // If the product with the given ID exists, it will return a 200 OK status with the updated product 
        // If the product does not exist, it will return a 404 Not Found status
        // Note: The service method should handle the logic for updating and return appropriate response.
        // Return type of this function should be ResponseEntity<Product> to indicate success or failure
        return productService.updateProduct(id, productDetails); // Updates an existing product by ID
    }

    @DeleteMapping("/{id}") // Handles DELETE requests to /products/{id}
    public void deleteProduct(@PathVariable Long id) {
        // TODO - Return HttpStatus.NO_CONTENT when successful else HttpStatus.NOT_FOUND
        // If the product with the given ID does not exist, it will return a 404 Not Found status
        // If the product is successfully deleted, it will return a 204 No Content status
        // Note: The service method should handle the logic for checking existence and deletion
        // and return appropriate response.
        // Return type of this function should be ResponseEntity<Void> to indicate success or failure
        productService.deleteProduct(id); // Deletes a product by its ID
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