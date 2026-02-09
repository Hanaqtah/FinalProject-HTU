# Project Quality Assurance: Multi-Platform Testing & Automation

## Overview
This repository contains a complete end-to-end Quality Assurance (QA) project covering multiple testing layers across **Web**, **Mobile**, and **API** platforms. It demonstrates manual and automated testing, performance evaluation, and CI/CD integration.


## Objective
Validate system correctness, reliability, scalability, and maintainability using industry-standard QA tools and practices.


## Project Scope
This project includes:

- Manual Testing and Test Plan  
- Web UI Automation (Selenium + TestNG)  
- Mobile UI Automation (Appium + WebdriverIO)  
- REST API Testing (Functional, Negative, and Data-driven)  
- API Performance Testing (Smoke & Load with k6)  
- CI/CD-Ready Execution using GitHub Runners  


## Systems Under Test (SUT)
- **Web Application:** [SauceDemo](https://www.saucedemo.com)  
- **Mobile Application:** HyperMax Android App (APK v25.8.2)  
- **API:** [DummyJSON REST API](https://dummyjson.com)  


## Prerequisites & Setup

### General
- Git  
- Node.js (v16+)  
- Java JDK (v8+)  
- Google Chrome  
- Android Studio & Emulator (Pixel 5 recommended)  

### API & Performance Testing
- Postman  
- Newman CLI  
- k6  

### Web Automation
- Eclipse IDE  
- Maven  

### Mobile Automation
- Appium Server  
- WebdriverIO  


## How to Run API Tests

### Using Postman
1. Open Postman.  
2. Import the API collection: `DummyJasonFinalProject.postman_collection.json` and environment: `DummyJsonEnv.postman_environment.json`.  
3. Select the appropriate environment.  
4. Run the collection via **Collection Runner**.  
5. For data-driven testing, select the CSV file `UsersData.csv`.  
6. Review results in Postman.

### Using Newman (CLI)
```
newman run DummyJasonFinalProject.postman_collection.json -e DummyJsonEnv.postman_environment.json -d UsersData.csv
```

**Evidence:** HTML and XML reports are available in the **Postman-Automation** branch.


## How to Run Performance Tests (k6)
1. Navigate to the `performance-tests` directory.  
2. Run the smoke or load test:
```
k6 run SmokeTest.js
k6 run LoadTest.js
```

**Evidence:** CLI metrics and Markdown tables in the **K6-Results** branch.


## How to Run Web UI Automation (Selenium + TestNG)
1. Checkout the **Selenium-Automation** branch.  
2. Open the project in Eclipse.  
3. Ensure Maven dependencies are installed.  
4. Run the desired TestNG test class or suite.

**Reports:** Generated in `test-output/index.html`.


## How to Run Mobile Automation (Appium)
1. Checkout the **Appium-Automation** branch.  
2. Start the Android Emulator (Pixel 5).  
3. Start the Appium Server.  
4. Navigate to the project directory and run:
```
node HyperMaxTest.js
```

**Execution Output:**
- Real-time execution on the emulator  
- Logs printed in the terminal  
- Screenshots stored in `Appium_ScreenShot` in **Appium-Automation** branch  


## Evidence and Screenshots
All testing evidence is stored for traceability:

- **Manual Testing:** Test case report with linked screenshots (**TestCases-Report** branch)  
- **Automation Evidence:** Captured during execution in respective branches  
- **Bug Evidence:** Included in bug reports with screenshots (**Bug-Reports** branch)  


## Tech Stack & Tools
| Layer                  | Tools & Frameworks                              |
|------------------------|-----------------------------------------------|
| Manual Testing         | Exploratory & Functional Testing              |
| Web Automation         | Selenium WebDriver + TestNG (Java)           |
| Mobile Automation      | Appium + WebdriverIO (JavaScript)            |
| API Testing            | Postman & Newman CLI                           |
| Performance Testing    | k6 (Smoke & Load)                              |
| CI/CD                  | GitHub Actions / Self-Hosted Runner           |


## Repository & Branching Strategy
To maintain a clean and executable environment, the project is structured across multiple branches:

- **main:** Core files for CI/CD execution (k6 smoke test script, Postman collection & environment).  
- **Feature / Specialized Branches:**  
  - `Test-Documentation` – Full Test Plan  
  - `TestCases-Report` – Manual Test Cases & Screenshots  
  - `Bug-Reports` – All identified bugs  
  - `Selenium-Automation` – Web UI automation framework  
  - `Appium-Automation` – Mobile UI automation framework  
  - `Postman-Automation` – API testing suite with CSV data  
  - `K6-Results` – Performance test results  


## Author
**Hala Ahmad Al Hanaqtah**  
ICT Upskilling Program – Supervised by Dr. Ashraf Al-Smadi  
**Date:** February 10, 2026

