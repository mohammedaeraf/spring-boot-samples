## 🧪 Spring Boot Project Test: Recipe API

### 🔍 Objective:

Create a Spring Boot application to manage recipes. You need to implement full CRUD functionality on the `Recipe` entity, and also include filtering and search features.

---

### ✅ Requirements:

#### 1. **Create a `Recipe` Entity** based on the following sample recipe below:

```json
{
  "id": 2,
  "name": "Vegetarian Stir-Fry",
  "ingredients": "Tofu cubed, Broccoli florets, Carrots, sliced",
  "prepTimeMinutes": 15,
  "cuisine": "Asian",
  "rating": 4.7
}
```

---

#### 2. **Implement the following REST API Endpoints:**

| HTTP Method | Endpoint        | Description      |
| ----------- | --------------- | ---------------- |
| POST        | `/recipes`      | Add a new recipe |
| GET         | `/recipes`      | Get all recipes  |
| GET         | `/recipes/{id}` | Get recipe by ID |
| PUT         | `/recipes/{id}` | Update recipe    |
| DELETE      | `/recipes/{id}` | Delete recipe    |

---

#### 3. **Additional Features:**

* 🔎 **Search Recipes by Title:**

  * Endpoint: `GET /recipes/search?name=stir`
  * Description: Case-insensitive search for recipe name containing a keyword.

* 🔧 **Filter by Cuisine and Prep Time Range:**

  * Endpoint: `GET /recipes/filter?cuisine=Asian&minTime=10&maxTime=30`
  * Description: Return recipes matching the cuisine and within the prep time range.

---

### 📂 Project Structure Guidelines:

You may organize your application into the following layers:

* `model` – For the `Recipe` entity.
* `repository` – Extending `JpaRepository<Recipe, Long>`.
* `service` – For business logic.
* `controller` – For exposing REST APIs.

---

### 📝 Notes:

* Use `@RestController`, `@GetMapping`, `@PostMapping`, etc. appropriately.
* Use `@RequestParam` for filters and search.
* Use `@PathVariable` for ID-based operations.
* Use Spring Boot 3.x and Java 17+ if possible.
* You may use an in-memory database like H2.


