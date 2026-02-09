**Project Quality Assurance: Multi-Platform Testing & Automation**

**Project Overview**

This project presents a comprehensive end-to-end software testing lifecycle applied to demonstrates advanced QA engineering practices starting from manual exploratory testing and progressing into UI automation, API validation, performance modeling, and CI/CD-ready execution.

**Project Objective**

The primary objective is to validate system correctness, reliability, scalability, and maintainability using industry-standard tools.

**Systems Under Test**

- **Web:** [SauceDemo](https://www.saucedemo.com/) - Simulating e-commerce workflows (authentication, cart management, and checkout).
- **Mobile:** **HyperMax App (APK v25.8.2)** - Android shopping application tested via Appium on a Pixel 5 emulator.
- **API:** [DummyJSON](https://dummyjson.com/) - RESTful API used for functional, data-driven, and performance testing.

**Tech Stack & Tools**

- **Manual Testing:** Exploratory and functional validation.
- **Web Automation:** Selenium WebDriver with TestNG (Java).
- **Mobile Automation:** Appium with WebdriverIO.
- **API Testing:** Postman & Newman CLI.
- **Performance Testing:** k6 (Smoke and Load testing).
- **CI/CD:** GitHub Actions / Self-Hosted Runner.

**Reporting Tools:**

- Manual testing evidence via screenshots
- TestNG execution reports
- Newman HTML/XML API reports
- k6 performance metrics and analysis tables

**Test Strategy**

- Manual exploratory and functional testing
- UI automation for critical user journeys
- Mobile automation for native Android flows
- REST API testing (CRUD, authentication, negative cases)
- Performance testing (Smoke & Load)
- Reporting and result analysis

**Repository & Branching Strategy**

**Important:** To maintain a clean and executable environment, the project is structured across multiple branches:

- **main Branch:** Contains the core files required to activate the **CI/CD runner**. This includes the k6 smoke test scripts and Postman API collection/environment files.
- **Feature Branches:** All detailed documentation and specialized automation suites are maintained on separate branches, including:
  - **Test Documentation:** Full Test Plan, 30+ Test Cases, and 10 detailed Bug Reports.
  - **Web Automation:** Selenium + TestNG framework (Java).
  - **Mobile Automation:** Appium + WebdriverIO (JavaScript).
  - **API Testing:** Full Postman suite with data-driven CSV files.
  - **Performance:** Comprehensive k6 load testing profiles.

**Author**

**Hala Ahmad Al Hanaqtah** _ICT Upskilling Program_ _Supervised by Dr. Ashraf Al-Smadi_ _February 10, 2026_
