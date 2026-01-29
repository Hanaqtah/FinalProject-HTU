Selenium Automation Final Project – SauceDemo
========================================

Project Overview
----------------
This project is a Selenium WebDriver automation framework built using Java, TestNG, and Maven in Eclipse IDE.
It automates end-to-end user flows on the SauceDemo application for two user types:

- Standard User
- Problem User

The project validates core e-commerce functionalities such as login, product filtering, cart operations, checkout, and logout.

Technologies and Tools
---------------------
- Java
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Eclipse IDE
- ChromeDriver

Maven Dependencies
------------------
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.35.0</version>
</dependency>

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
</dependency>

Project Structure
-----------------
src/test/java

 ├── Standard_User_Cases

 │   ├── StandardUserTestCases.java

 │   └── StandardUserTestData.java
 
 ├── Problem_User_Cases

 │   ├── ProblemUserTestCases.java

 │   └── ProblemUserTestData.java

 │
    pom.xml

    testng.xml

    README.md

Test Scenarios Covered
---------------------
Standard User Test Cases:
1. Login with valid credentials
2. Filter products using random sorting options
3. View product description
4. Add random products to cart
5. Remove products from cart
6. Complete Happy Checkout flow
7. Complete Sad Checkout flow
8. Logout successfully

Includes validation for:
- URL navigation
- Button state changes (Add to Cart to Remove, Remove to Add to Cart)
- Order confirmation message

Problem User Test Cases:
1. Login with problem user credentials
2. Add random items to cart
3. Remove items from cart
4. Validate button state behavior

These tests help identify UI and functional issues specific to the Problem User role.

How to Run the Tests
--------------------
Option 1: Run from Eclipse
- Right-click on a test class
- Run As -> TestNG Test

Option 2: Run with Maven
- Open terminal / command prompt
- Navigate to project directory
- Run: mvn test

Test Reports
------------
Default TestNG reports are generated in the 'test-output' directory.

Notes and Assumptions
---------------------
- Tests use random selection for products and filters.
- Tests are state-dependent (cart contents may affect results).
- Thread.sleep is used for synchronization and can be replaced with WebDriverWait for better stability.
- ChromeDriver version must match the installed Chrome browser.

Key Automation Concepts Used
----------------------------
- Page interaction using locators (ID, CSS, XPath)
- Randomized test data selection
- Assertions using TestNG
- Test prioritization and invocation count
- Separation of test logic and test data
- Implicit waits and browser lifecycle management

Author
------
Automation Final Project – Selenium WebDriver
Developed using Eclipse IDE
