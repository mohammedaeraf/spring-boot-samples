package com.fla.db.service;

import com.fla.db.model.Product;
import com.fla.db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired // Injects the ProductRepository dependency
    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<Product> getProducts() {
        // Retrieves all products from the database
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        // Retrieves a product by its ID, or returns a dummy product if not found
        Product dummyProduct = new Product();
        dummyProduct.setId(0L);
        dummyProduct.setTitle("Unknown Product");
        dummyProduct.setPrice(0);
        return productRepository.findById(id).orElse(dummyProduct);
    }

    public Product createProduct(Product product) {
        // Creates and saves a new product entity
        // perform validations and business logic
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        // Updates an existing product's title and price by its ID
        Product product = productRepository.findById(id).orElseThrow();
        product.setTitle(productDetails.getTitle());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        // Deletes a product by its ID
        productRepository.deleteById(id);
    }

}