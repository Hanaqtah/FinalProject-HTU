 Appium Automation - HyperMax Mobile Testing

## Project Overview

This project is an **Appium automation framework** built using **WebdriverIO and Chai** for testing the Hyper Max Android application on a **Pixel 5 emulator**. It automates end-to-end user flows for grocery shopping, validating core functionalities such as:

The project ensures that users can:

- View product details
- Add products to the cart
- Adjust product quantities
- Remove products from the cart
- Attempt checkout and handle empty field validations

**Note:**  
The `hypermax-25-8-2.apk` file was downloaded and installed on a local device to perform these tests.



## Technologies and Tools

- **Node.js**
- **WebdriverIO**
- **Chai** (Assertions)
- **Appium 2.x**
- **Appium Inspector**
- **Android Emulator (Pixel 5)**
- **Notepad++**
- **Hyper Max APK** (Downloaded for testing)



## Test Scenarios Covered

### Product Browsing and Selection

- Select a country and confirm
- Navigate to the **Frozen Food** category
- Select multiple products
- Verify product names are displayed correctly
- Add products to the cart

### Cart Operations

- Increase product quantity and assert correct quantity
- Verify **Add to Cart button** and **quantity selection** are displayed

### Checkout and Validation

- Navigate to the checkout page
- Click **Continue** on empty required fields
- Assert the **error message**: `"Please enter an email address and continue."`



## How to Run the Tests

 **Run from Node.js / Terminal**  
1. Open terminal / command prompt  
2. Install dependencies (if not done already)  
3. Start the Appium server in the terminal window  
3. Navigate to the project directory where your test script is located  
5. Run the test script in another terminal window:  
    path: C:\Users\MCC\OneDrive\OneDrive - Hashemite University\Desktop\Mobile\HyperMaxTest.js
    Example: node HyperMaxTest.js
6. Ensure the Hyper Max APK is installed on the emulator or device before running the test

**Notes:**

- You need two terminal windows: one for Appium, one for running the Node.js test  
- Make sure the emulator is running and ready  
- Tests will interact with the **installed APK automatically**



## Test Reports

- Test execution results are displayed in the terminal  
- Failed assertions throw **Chai AssertionErrors**  
- Screenshots can be captured using **Appium Inspector** or **WebdriverIO commands** for debugging



## Notes and Assumptions

- Tests run on valid emulator with an Android version compatible with the downloaded HyperMax APK  
- `driver.pause()` is used for synchronization  
- Product names, quantities, and cart items are validated using **Chai assertions**  
- Tests are dependent on the current state of the app (cart contents, previously added items)



## Author

**Automation Project - Appium Mobile Testing**  

Developed using **WebdriverIO, Chai, Appium Inspector, and Notepad++**
