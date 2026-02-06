# DummyJSON API - Postman Collection

## Overview
This repository contains a **Postman Collection, Environment Variables, and a CSV file** used to test the DummyJSON REST API.  
The collection covers **authentication, products, carts, and users**, including positive and negative test cases.  

**Note:**  
DummyJSON simulates write operations (POST/PUT/PATCH/DELETE), but data is **not persisted** on the server.


## Base Information
- **Base URL:** https://dummyjson.com  
- **API Docs:** https://dummyjson.com/docs  
- **Content-Type:** application/json  


## Project Structure
- `DummyJSON.postman_collection.json`  
- `DummyJSON.postman_environment.json`  
- `UsersData.csv`  
- XML/HTML Reports  
- README.md  


## Environment & Collection Variables
Variables are used across requests to simplify configuration for **authentication, carts, and products** endpoints, allowing easy updates during test execution.

**Note:**  
Environment variables are automatically updated during execution  


## Data-Driven Approach
The `UsersData.csv` file provides **dynamic input for users' endpoints**, allowing the same requests to run with different data for robust testing.


## Newman Reports
- Generated **XML and HTML reports** using **Newman**  
- Reports include **execution results and failed tests**  
- **Note:** Failures appear due to the authentication endpoint **messing token** 
  - DummyJSON sometimes executes requests correctly  
  - Other times, it fails to recognize that there is **no token**  


## How to Run the Tests
1. Open **Postman** and import the collection and environment files.  
2. Open the **Collection Runner**:  
   - Select your collection and environment.  
   - If using CSV data, click **Select File** under Data and choose `UsersData.csv`.  
   - Configure iterations (1 per CSV row).  
3. Click **Run** to execute the collection.  


## Author

**Automation Project – Postman & API Testing**  
Developed using **Postman, Newman, and CSV-based data-driven tests** for **testing and learning purposes**
