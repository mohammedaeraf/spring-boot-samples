package com.fla.db.service;

import com.fla.db.model.Product;
import com.fla.db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(Product product) {
        //  perform validations and business logic

        return productRepository.save(product);
    }



    public Product getProductById(Long id) {
        Product dummyProduct = new Product();
        dummyProduct.setId(0L);
        dummyProduct.setTitle("Unknown Product");
        dummyProduct.setPrice(0);
        return productRepository.findById(id).orElse(dummyProduct);
    }

    public Product updateProduct(Long id, Product productDetails) {

        Product product = productRepository.findById(id).orElseThrow();

        product.setTitle(productDetails.getTitle());
        product.setPrice(productDetails.getPrice());

        return productRepository.save(product);
    }
}