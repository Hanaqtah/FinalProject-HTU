# Sauce Demo - Test Case Report

## Project Overview

This repository contains test cases executed on the \*\*Sauce Demo (Swag Labs)\*\* application.

The goal of this testing effort is to validate core functionalities, ensure correct user flows, and identify functional defects.

\*\*Website URL: \*\* <https://www.saucedemo.com/>

\---

## Test Scope

### In Scope

\- User authentication (login / logout)

\- Product listing and sorting

\- Add to cart / Remove from cart

\- Products correct images / Products correct description

\- Checkout process

\- Order confirmation

### Out of Scope

\- Security testing

\- Cross-browser testing (only tested on Chrome browser)

\---

## Test Environment

\- \*\*Website: \*\* Sauce Demo (Swag Labs)

\- \*\*Testing Type: \*\* Functional Testing

\- \*\*Tools Used: \*\* Selenium / Manual Testing

\- \*\*Browser: \*\* Google Chrome

\- \*\*OS: \*\* Windows 11

\---

## Test Execution Summary

| Metric | Count |

|------|------|

| Total Test Cases | 30 |

| Passed | 11 |

| Failed | 19 |

\---

## Test Case Structure

Each test case includes:

\- Test Case ID

\- Description

\- Test Steps

\- Test Data

\- Expected Result

\- Actual Result

\- Status

\- Evidences

\- Notes if any

\---

## Sample Test Cases

### TC-01: Valid Login

\*\*Description: \*\* Verify Successful Login with Valid Credentials.

\*\*Test Steps: \*\*

1- Open SauceDemo website.

2- Enter "standard_user" in Username field.

3- Enter "secret_sauce" in Password field.

4- Click the "Login" button.

\*\*Test Data: \*\*

- UserName: standard_user,
- Password: secret_sauce.

\*\*Expected Result: \*\*

\- The user should be successfully logged in immediately and redirected to (Products) page.

\*\*Status: \*\* ✅ Passed

\---

## Conclusion

Core functionalities of the Sauce Demo application are working as expected.

Some issues were identified when logged in with different users. **As an example**, login and field validation problems occurred when testing with problem_user, which should be addressed before production-like testing.
