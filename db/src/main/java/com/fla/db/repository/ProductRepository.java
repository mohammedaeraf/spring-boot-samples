package com.fla.db.repository;

import com.fla.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data repository bean
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Inherits CRUD operations for Product entities with Long as the ID type
    // No need to implement methods; Spring Data JPA provides the implementation

    // Derived Queries
    List<Product> findByTitleContainingIgnoreCase(String searchTerm);

    List<Product> findByPriceBetween(int startPrice, int endPrice);

    List<Product> findByCategoryContainingIgnoreCaseOrderByTitle(String category);

    // Find products by brand, category, and price less than a value
    List<Product> findByBrandAndCategoryAndPriceLessThan(String brand, String category, double price);

    // Find products by brand or category
    List<Product> findByBrandOrCategory(String brand, String category);

    // Find products by brand and sort by price ascending
    List<Product> findByBrandOrderByPriceAsc(String brand);

    // Find products by category and sort by title descending
    List<Product> findByCategoryOrderByTitleDesc(String category);

    // Find products by brand and category, sort by price descending
    List<Product> findByBrandAndCategoryOrderByPriceDesc(String brand, String category);

    // Find all products sorted by title ascending
    List<Product> findAllByOrderByTitleAsc();

    @Query("SELECT p FROM Product p WHERE p.brand = :brand AND p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price")
    List<Product> getProductsByBrandPrice(String brand, int minPrice, int maxPrice);
}