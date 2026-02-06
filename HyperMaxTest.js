import { remote } from 'webdriverio';
import { expect } from 'chai';

const caps = {
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:app": "C:\\Users\\MCC\\OneDrive\\OneDrive - Hashemite University\\Desktop\\Mobile\\hypermax-25-8-2.apk",
  "appium:noReset": false,
  "appium:autoGrantPermissions": true
};

async function runTest() {
  const driver = await remote({
    protocol: 'http',
    hostname: '127.0.0.1',
    port: 4723,
    path: '/',
    capabilities: caps
  });

  await driver.pause(5000);
  
	//code works well

  const el1 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/layout_country_content\").instance(0)");
  await el1.click();
  await driver.pause(1000);
  
  const el2 = await driver.$("id:com.maf.hypermax:id/btn_confirm");
  await driver.pause(1000);
  // Assert confirm button is displayed
  expect(await el2.isDisplayed()).to.equal(true);
  await el2.click();
  await driver.pause(3000);

  const el3 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/ivCategoryCircleImage\").instance(2)");
  await driver.pause(1000);
  // Assert frozen  food category is displayed
  expect(await el3.isDisplayed()).to.equal(true);
  await el3.click();
  await driver.pause(1000);

  const el4 = await driver.$("-android uiautomator:new UiSelector().text(\"1\").instance(0)");
  await el4.click();
  await driver.pause(1000);

  const el5 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/product_image\").instance(0)");
  await el5.click();
  await driver.pause(2000);

  const el6 = await driver.$("id:com.maf.hypermax:id/pdpNewProductName");
  await driver.pause(1000);
  // Assert name is displayed
  expect(await el6.isDisplayed()).to.equal(true);
  // Assert product name is the one selected
  expect(await el6.getText()).to.equal('Siniora Chicken Breast 2Kg');
  await driver.pause(1000);
  
  const el7 = await driver.$("accessibility id:AddToCartButton");
  await el7.click();
  await driver.pause(3000);
  
  const el8 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/product_image\").instance(0)");
  await el8.click();
  await driver.pause(1000);
  
  const el9 = await driver.$("id:com.maf.hypermax:id/pdpNewProductName");
  await driver.pause(1000);
  // Assert name is displayed
  expect(await el9.isDisplayed()).to.equal(true);
  // Assert product name is the one selected
  expect(await el9.getText()).to.equal('Alwadi Tender Chicken Breast 2 Kg');
  await driver.pause(1000);
  
  const el10 = await driver.$("accessibility id:AddToCartButton");
  await el10.click();
  await driver.pause(3000);
  
  const el11 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/product_image\").instance(1)");
  await el11.click();
  await driver.pause(1000);
  
  const el12 = await driver.$("accessibility id:AddToCartButton");
  await el12.click();
  await driver.pause(1000);
  
  const el13 = await driver.$("id:com.maf.hypermax:id/quantity_increase_btn");
  await el13.click();
  await driver.pause(1000);
  
  // Assert quantity is 2
  const el14 = await driver.$("accessibility id:SelectQuantity");
  await driver.pause(2000);
  expect(await el14.getText()).to.equal('2 Pieces');
  await el14.click();
  await driver.pause(1000);

  const el15 = await driver.$("-android uiautomator:new UiSelector().className(\"android.widget.FrameLayout\").instance(7)");
  await el15.click();
  await driver.pause(1000);

  const el16 = await driver.$("-android uiautomator:new UiSelector().resourceId(\"com.maf.hypermax:id/navigation_bar_item_icon_view\").instance(3)");
  await el16.click();
  await driver.pause(1000);
  
  const el17 = await driver.$("-android uiautomator:new UiSelector().className(\"android.widget.Button\").instance(3)");
  await el17.click();
  await driver.pause(2000);
   
  const el18 = await driver.$("-android uiautomator:new UiSelector().className(\"android.widget.Button\").instance(6)");
  await el18.click();
  await driver.pause(1000);
  
  const el19 = await driver.$("-android uiautomator:new UiSelector().className(\"android.widget.Button\").instance(1)");
  await el19.click();
  await driver.pause(1000);
  
  // Wait for the error message to appear
  const errorMessage = await driver.$('-android uiautomator:new UiSelector().text("Please enter an email address and continue.")');
  await driver.pause(2000);

  // Assert it is displayed
  expect(await errorMessage.isDisplayed()).to.equal(true);

	// end of code
	
  await driver.pause(3000);
  await driver.deleteSession();
}

runTest();
