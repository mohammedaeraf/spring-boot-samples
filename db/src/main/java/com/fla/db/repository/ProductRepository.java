package com.fla.db.repository;

import com.fla.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data repository bean
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Inherits CRUD operations for Product entities with Long as the ID type
    // No need to implement methods; Spring Data JPA provides the implementation

    List<Product> findByTitleContainingIgnoreCase(String searchTerm);

    List<Product> findByPriceBetween(int startPrice, int endPrice);


}