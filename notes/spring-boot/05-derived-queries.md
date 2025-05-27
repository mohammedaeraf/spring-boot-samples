## Derived Queries in Spring Data JPA

### Sample Derived Queries for the `Product` Model

Spring Data JPA provides naming conventions to create derived queries automatically based on the method names in the repository interface. Below is a list of possible derived queries for the given `Product` class:

```
public class Product {
	private Long id;
	private String title;
	private double price;
	private String brand;
	private String category;
}
```

**1. Queries Based on `title` Field**

---

- `findByTitle(String title)`
  Retrieves products matching the exact title.
- `findByTitleContaining(String keyword)`
  Retrieves products where the title contains the given keyword.
- `findByTitleStartingWith(String prefix)`
  Retrieves products with titles starting with the given prefix.
- `findByTitleEndingWith(String suffix)`
  Retrieves products with titles ending with the given suffix.
- `findByTitleIgnoreCase(String title)`
  Retrieves products with the title, ignoring case sensitivity.

---

### **2. Queries Based on `price` Field**

- `findByPrice(double price)`
  Retrieves products with the exact price.
- `findByPriceGreaterThan(double price)`
  Retrieves products with prices greater than the given value.
- `findByPriceLessThan(double price)`
  Retrieves products with prices less than the given value.
- `findByPriceBetween(double minPrice, double maxPrice)`
  Retrieves products within the specified price range.

---

### **3. Queries Based on `brand` Field**

- `findByBrand(String brand)`
  Retrieves products with the exact brand.
- `findByBrandContaining(String keyword)`
  Retrieves products where the brand contains the given keyword.
- `findByBrandIgnoreCase(String brand)`
  Retrieves products with the brand, ignoring case sensitivity.

---

### **4. Queries Based on `category` Field**

- `findByCategory(String category)`
  Retrieves products in the specified category.
- `findByCategoryContaining(String keyword)`
  Retrieves products where the category contains the given keyword.
- `findByCategoryIgnoreCase(String category)`
  Retrieves products in the specified category, ignoring case sensitivity.

---

### **5. Combining Fields**

- `findByBrandAndCategory(String brand, String category)`
  Retrieves products matching both brand and category.
- `findByBrandOrCategory(String brand, String category)`
  Retrieves products matching either brand or category.
- `findByTitleAndPrice(String title, double price)`
  Retrieves products with the exact title and price.
- `findByCategoryAndPriceBetween(String category, double minPrice, double maxPrice)`
  Retrieves products in the specified category and within the price range.

---

### **6. Queries Using Negation**

- `findByTitleNot(String title)`
  Retrieves products that do not match the given title.
- `findByCategoryNot(String category)`
  Retrieves products that are not in the specified category.

---

### **7. Queries with Sorting**

- `findByCategoryOrderByPriceAsc(String category)`
  Retrieves products in the specified category sorted by price in ascending order.
- `findByBrandOrderByTitleDesc(String brand)`
  Retrieves products by brand sorted by title in descending order.

---

### **8. Queries with Count or Exists**

- `countByCategory(String category)`
  Returns the count of products in the specified category.
- `existsByTitle(String title)`
  Checks if a product with the given title exists.

---

### **9. Queries with Stock-Level Checks (if added)**

If a `stock` field exists, you can also define:

- `findByStockGreaterThan(int stock)`
  Retrieves products with stock above a certain threshold.
- `findByStockIsZero()`
  Retrieves products where the stock is zero.

---

These derived queries are generated based on method names, and Spring Data JPA automatically implements them.
