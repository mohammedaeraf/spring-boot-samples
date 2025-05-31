### 📝 **Assignment 08: Implement ResponseEntity and Proper HTTP Status Codes in ProductController**

#### **Objective**

Refactor the `ProductController` to use `ResponseEntity` for all POST, PUT, and DELETE endpoints. Ensure that each endpoint returns the appropriate HTTP status code based on the outcome of the operation.

---

### 📌 **Requirements**

1. **Update the POST endpoint (`/products`)**  
   - Use `ResponseEntity<Product>` as the return type.
   - Return `HttpStatus.CREATED (201)` when a product is successfully created.
   - Return `HttpStatus.BAD_REQUEST (400)` if the product cannot be created (e.g., validation fails).

2. **Update the PUT endpoint (`/products/{id}`)**  
   - Use `ResponseEntity<Product>` as the return type.
   - Return `HttpStatus.OK (200)` when a product is successfully updated.
   - Return `HttpStatus.NOT_FOUND (404)` if the product with the given ID does not exist.

3. **Update the DELETE endpoint (`/products/{id}`)**  
   - Use `ResponseEntity<Void>` as the return type.
   - Return `HttpStatus.NO_CONTENT (204)` when a product is successfully deleted.
   - Return `HttpStatus.NOT_FOUND (404)` if the product with the given ID does not exist.

4. **Update the service layer if needed** to support these responses.

5. **Test all endpoints** using Postman or curl to verify correct status codes and responses.

---

### ✅ **Deliverables**

- Updated `ProductController` with `ResponseEntity` and proper status codes for POST, PUT, and DELETE.
- Any necessary changes in the service layer.
- Example API responses or screenshots showing correct status codes for each operation.