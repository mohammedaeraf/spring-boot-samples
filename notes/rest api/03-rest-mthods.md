### HTTP Methods in REST
---

**1. GET Method**

- **Description**:
The `GET` method is used to retrieve data from the server. It is typically used to request resources (like a list of users, a specific product, etc.) without making any modifications. The `GET` request should not have any side effects, meaning it does not alter the state of the resource on the server.
- **Example**:
    - `GET /users`: Retrieves a list of all users.
    - `GET /users/1`: Retrieves the details of the user with ID 1.
- **Use Case**:
    - Fetching a list of products from an e-commerce site.
    - Displaying details of a specific article on a blog.
- **Key Points**:
    - Safe and idempotent: Multiple identical `GET` requests should produce the same result.
    - Should not modify data on the server.

---

**2. POST Method**

- **Description**:
The `POST` method is used to send data to the server to create a new resource. It is commonly used when submitting forms, uploading files, or creating new records in a database. Unlike `GET`, `POST` requests can have side effects, as they typically result in a change in the server's state.
- **Example**:
    - `POST /users`: Creates a new user with the data provided in the request body (e.g., name, email).
    - `POST /products`: Adds a new product to the catalog.
- **Use Case**:
    - Registering a new user on a website.
    - Posting a new comment on a blog post.
- **Key Points**:
    - Not idempotent: Sending the same `POST` request multiple times may create multiple resources.
    - The request body usually contains the data needed to create the resource.

---

**3. PUT Method**

- **Description**:
The `PUT` method is used to update an existing resource or create a new resource if it does not exist. It is often used for complete updates, where you replace the current state of the resource with the new data provided. A `PUT` request is idempotent, meaning multiple identical requests will have the same effect as a single request.
- **Example**:
    - `PUT /users/1`: Updates the user with ID 1 with the new data provided (e.g., changing their name or email).
    - `PUT /products/10`: Replaces the product with ID 10 with the new product data.
- **Use Case**:
    - Updating user profile information.
    - Replacing details of a product in an inventory system.
- **Key Points**:
    - Idempotent: Sending the same `PUT` request multiple times has the same effect.
    - Typically used for full updates where the entire resource is replaced.

---

**4. DELETE Method**

- **Description**:
The `DELETE` method is used to remove a resource from the server. When you make a `DELETE` request, the resource identified by the URI is deleted. Like `PUT`, the `DELETE` method is idempotent—sending the same `DELETE` request multiple times has the same outcome (the resource is deleted or does not exist).
- **Example**:
    - `DELETE /users/1`: Deletes the user with ID 1.
    - `DELETE /products/10`: Removes the product with ID 10 from the catalog.
- **Use Case**:
    - Deleting a user account.
    - Removing an item from an inventory.
- **Key Points**:
    - Idempotent: The result is the same no matter how many times the request is sent.
    - Once deleted, the resource should no longer be accessible.

---

**5. PATCH Method**

- **Description**:
The `PATCH` method is used to apply partial updates to a resource. Unlike `PUT`, which replaces the entire resource, `PATCH` is used when only specific attributes of a resource need to be updated. It is useful when only a few fields need to be changed, rather than the entire resource.
- **Example**:
    - `PATCH /users/1`: Updates only specific fields (e.g., changing the user’s email or phone number) for the user with ID 1.
    - `PATCH /products/10`: Updates the price of the product with ID 10 without altering other product details.
- **Use Case**:
    - Updating the status of an order (e.g., marking it as shipped).
    - Changing the password of a user without modifying other profile data.
- **Key Points**:
    - Not necessarily idempotent: The result of multiple identical `PATCH` requests may differ if they depend on the current state.
    - Ideal for partial updates.

---

### Summary:

Each HTTP method has a specific role in REST APIs:

- **GET**: Retrieve data.
- **POST**: Create a new resource.
- **PUT**: Update or replace a resource.
- **DELETE**: Remove a resource.
- **PATCH**: Partially update a resource.

Understanding how to use these methods appropriately ensures a consistent, reliable, and maintainable RESTful API design for Java Full Stack developers.