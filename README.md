## Project Performance Testing: DummyJSON API

This repository contains k6 performance testing scripts for the **DummyJSON API**. The goal of this testing suite is to verify the stability, reliability, and responsiveness of the API under different traffic conditions.

## 1. Objectives
The performance testing is designed to:

- Identify API response times and throughput.

- Detect potential bottlenecks and system limits.

- Ensure the system meets defined error rate and latency thresholds.

- Validate endpoint functionality under concurrent user pressure.

## 2. Targeted Endpoints
The scripts target three specific endpoints to evaluate core system performance:


- **GET /carts:** Retrieves a list of all cart records.


- **GET /products/{validID}:** Fetches detailed information for a specific product using a path parameter.


- **GET /users/search:** Executes a filtered search for user profiles using a query parameter.

## 3. Test Scenarios
### Smoke Test
The Smoke Test is used as a baseline to verify that the system is stable and can handle a minimal load without errors.


- **Virtual Users (VUs):** 3.


- **Duration:** 30 seconds.


- **Purpose:** To confirm basic functionality and baseline performance before moving to heavier load.

### Load Test
The Load Test simulates a more realistic production scenario to observe how the system handles increased concurrency.


- **Virtual Users (VUs):** 20.


- **Duration:** 30 seconds.


- **Purpose:** To identify system degradation, connection overhead, or potential resource exhaustion under stress.


## 4. Execution
To run these tests, ensure you have k6 installed and execute the following commands in your terminal:

- To run the Smoke Test **k6 run SmokeTest.js**

- To run the Load Test **k6 run LoadTest.js**
