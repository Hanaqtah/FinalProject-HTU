**DummyJSON API - Postman Collection**

- This repository contains a Postman Collection, Environment Variables, and a CSV File used to test the DummyJSON REST API.
- The collection covers authentication, products, carts, and users' endpoints, including positive and negative test cases.
- The users' endpoints, are being tested based on data obtained from csv file.

--

**NOTE:**

- DummyJSON simulates write operations (POST/PUT/PATCH/DELETE), but data is not persisted on the server.

--

**Base Information:**

- **Base URL:** <https://dummyjson.com>
- **API Docs:** <https://dummyjson.com/docs>
- **Content-Type:** application/json

--

**Project Structure**

- DummyJSON.postman_collection.json
- DummyJSON.postman_environment.json
- UsersData.csv
- XML Report
- HTML Report
- README.md

--

**Environment Variables:**

- Environment variables are automatically updated using Postman scripts.
- The environment file contains reusable variables used across requests:

--

| **Variable Name** | **Description** |
| --- | --- |
| baseUrl | API base URL (<https://dummyjson.com>) |
| validID | Valid resource ID used for positive test cases (product, user, or cart) |
| invalidID | Non-existing or invalid ID used for negative test cases |
| userId | ID of the authenticated (logged-in) user |
| NewQuantity | Quantity value used when updating product or cart items |
| user_email | Email address of the authenticated user |
| access_token | JWT access token captured after successful login |
| refresh_token | Token used to request a new access token |
| invalidSearch | Search keyword used for negative search test cases |

--

**Collection Variables:**

- These variables are defined at the **collection level** and are used across multiple requests.

| **Variable Name** | **Value** | **Description** |
| --- | --- | --- |
| searchProduct | iPhone | Product keyword used for product search requests |
| NewProductID | 195 | ID used when creating a new product (simulated) |
| NewProductTitle | swarovski swan bracelet | Title used when creating a new product |
| NewProductPrice | 29.99 | Price used when creating a new product |
| updatedTitle | Chicken Nuggets | Updated title used in product update requests |
| searchName | Emily | Keyword used for searching users |

--

**Authentication Folder**

- POST /auth/login

purpose: Obtain JWT access token

Body:

{   "username": "emilys",

&nbsp;    "password": "emilyspass"}

Assertions:

- Status code is 200
- accessToken exists
- Token saved to environment
- GET /auth/me

Purpose: Protected endpoint validation

Assertions:

- Status code is 200
- Returned user ID matches logged-in user
- POST /auth/refresh

Purpose: Obtain a new JWT access token using a valid refresh token,

without re-logging in.

Body:

{ "refreshToken": "{{refresh_token}}" }

Assertions:

- Status code is 200
- Response contains a new accessToken and refreshToken
- Token saved to environment

**Negative Tests**

- Missing token → 401 Unauthorized
- Invalid token → 400 Unauthorized

--

**Products Folder:**

- GET /products

Purpose: Retrieve product list

Assertions:

- Status code 200
- products are an array
- products have required keys (id, title, price exist)
- GET /products/{id}

Purpose: Get single product

Assertions:

- Status code 200
- products have required keys (id, title, price exist)
- returned id matches id sent in URL.
- GET /products/search?q={{searchProduct}}

Purpose: Search products

Assertions:

- Status code 200
- Returned products description contain search keyword
- POST /products/add

Purpose: Create product (simulated)

Body:

{ "id": {{NewProductID}},

"title": "{{NewProductTitle}}",

"price": {{NewProductPrice}} }

Assertions:

- Status code 201 Created
- Valid required keys (id, price, title)
- Returned fields match input
- PUT/PATCH /products/{id}

Purpose: Update product (simulated)

Body:

{ "title": "{{updatedTitle}}" }

Assertions:

- Status code 200
- Updated field reflects new value
- DELETE /products/{id}

Purpose: Delete product (simulated)

Assertions:

- Status code 200
- isDeleted = true

**Negative Tests:**

- Invalid id → 404 Not Found, Response should include a message "Product with id \\'' +InvalidID+ '\\' not found".
- Invalid search → 200 Status, Total is 0 and Products array is empty.
- Invalid delete → 404 Not Found, Response should include a message "Product with id '{{invalidID}}' not found".

--

**Carts Folder:**

- GET /carts

Purpose: Retrieve all carts

Assertions:

- Status code 200
- Carts are an array
- Valid required keys (id, products, total, userId)
- GET /carts/{id}

Purpose: Retrieve single cart

Assertions:

- Status code 200
- Valid required keys (id, products, total, userId)
- Returned id matches id sent in URL.
- GET /carts/user/{userId}

Purpose: Retrieve carts for a user

Assertions:

- Status code 200
- All carts have userId equal to requested ID
- POST /carts/add

Purpose: Create cart

Body:

{ "userId":{{userID}} ,

"products": \[

{"id": 1, "quantity": 1},

{"id": 2,quantity": 3} \] }}

Assertions:

- Status code 201
- Total and Discounted Total exists
- Returned id matches id sent in URL.
- PUT/PATCH /carts/{id}

Purpose: Update cart quantities (simulated)

Body:

{ "userId": {{userID}},

"products": \[

{ "id": 1,

"quantity": {{NewQuantity}} } \]}

Assertions:

- Status code 200
- Updated quantities reflected in response
- Returned id matches id sent in URL.
- DELETE /carts/{id}

Purpose: Delete cart (simulated)

Assertions:

- Status code 200
- isDeleted = true

**Negative Tests:**

- Invalid id → 404 Not Found, Response should include a message "Cart with id \\'' +InvalidID+ '\\' not found"
- Invalid delete → 404 Not Found, Response should include a message "Cart with id '{{invalidID}}' not found"

--

**Users Folder:**

- **Note:** the users folder requests use data dynamically from a CSV file. The variable fields ,sent in the request body and as URL parameter, are populated from this CSV during execution.

- GET /users

purpose: Retrieve the list of all users.

Assertions:

- Status code 200
- Users array exists and > 0
- Valid keys required (id, email, firstName, role)
- GET /users/{id}

purpose**:** retrieve detailed information for a specific user by ID.

note: the value (id) are dynamically retrieved from a **CSV file**.

Assertions:

- Status code 200
- Returned id matches id sent in URL.
- Valid keys required (id, email, firstName, role)
- GET /users/search?q={{Search_Name}}

Purpose: search for users whose first name matches the provided search keyword.

note: the value (Search_Name) are dynamically retrieved from a **CSV file**.

Assertions:

- Status code 200
- Users Array is Not Empty
- First Name has the Searched Word
- POST /users/add (Simulated)

purpose: create a new user with the provided details (simulated request, data is not persisted).

note: these values (UserFirstName, UserLastName, UserAge) are dynamically retrieved from a **CSV file**.

Body:

{ "firstName": "_{{UserFirstName}}_",

&nbsp;   "lastName": "_{{UserLastName}}_",

&nbsp;   "age": _{{UserAge}}_ }

Assertions:

- Status code 200
- Response has an id
- Returned Fields Match Input
- PATCH /users/{id}

purpose: create a new user with the provided details (simulated request, data is not persisted).

note: these values (UserFirstName, UserLastName, UserAge) are dynamically retrieved from a **CSV file**.

Body:

{  "firstName": "_{{UserFirstName}}_",

&nbsp;   "email": "_{{UserEmail}}_" }

Assertions:

- Status code 200
- Response has an id
- Returned Fields Match Input
- DELETE /users/{id}

Purpose: Delete user (simulated)

Assertions:

- Status code 200
- isDeleted = true

**Negative Tests**

- Invalid id → 404 Not Found, Response should include a message "User with id \\'' +InvalidID+ '\\' not found"
- Invalid search → 200 Status, Users Array is Empty and Total is 0
- Invalid delete → 404 Not Found, Response should include a message "User with id '{{invalidID}}' not found"
