package Standard_User_Cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class StandardUserTestCases extends StandardUserTestData{
	
	@BeforeTest
	public void SetUp() {
		driver.get(LogInPage);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	@Test(priority=1)
	public void LogIn() {
		
		// locating username, password fields and login button
		WebElement UserNameFieldInput = driver.findElement(By.id("user-name"));
		WebElement PasswordFieldInput = driver.findElement(By.id("password"));
		WebElement LogInBtn =  driver.findElement(By.id("login-button"));
		
		// filling in fields with information
		UserNameFieldInput.sendKeys(UserName);
		PasswordFieldInput.sendKeys(Password);
		LogInBtn.click();
		
		// obtaining the URL of the next page navigated to after LogIn
		String NextPage = driver.getCurrentUrl();
	    // ensure the next navigated page is HomePage
		Assert.assertEquals(NextPage, HomePageUrl);
	}
	
	
	@Test(priority=2, enabled=true)
	public void FilteringItems() {
		
		// locating the filtering button 
		WebElement FilteringButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		
		// parsing the country web element as its right-full type of select
		Select FilterSelect = new Select(FilteringButton);
	
		// locating all filtering options 
		List <WebElement> AllSelectOptions = FilteringButton.findElements(By.tagName("option"));
		
		// an number corresponds to the option's number
		int NumberOfOptions = AllSelectOptions.size();
		// generating random number 
		int RandomOption = rand.nextInt(0,NumberOfOptions);
		
		// obtaining selected filter
		String FilterSelected = AllSelectOptions.get(RandomOption).getText();
		
		// selecting a random filter 
		FilterSelect.selectByIndex(RandomOption);
		
		// checking if its the one selected
		boolean ActualFilter = driver.getPageSource().contains(FilterSelected);
		Assert.assertEquals(ActualFilter, true);
		
	}
	
	
	@Test(priority=3, enabled=true, invocationCount= 1)
	public void ViewItemDescription() throws InterruptedException {
		
		// ensure user is in Products page
		//driver.navigate().to(HomePageUrl);
		
		Thread.sleep(3000);
		
		// obtaining all items' names
		List <WebElement> AllItemNames = driver.findElements(By.className("inventory_item_name"));
		// generating random number 
		int RandomItem = rand.nextInt(0,AllItemNames.size());
	
		// clicking on a random item 
		String ExpectedItem = AllItemNames.get(RandomItem).getText();
		AllItemNames.get(RandomItem).click();
		
		// checking if the description is for selected item
		boolean ActualDescription = driver.getPageSource().contains(ExpectedItem);
		Assert.assertEquals(ActualDescription, true);
		
		Thread.sleep(3000);
		// Navigating back to Products Page
		driver.navigate().back();
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority=4, enabled=true, invocationCount= 3)
	public void AddingRandomItemsToCart() throws InterruptedException {
		
		// locating all AddToCart buttons 
		List <WebElement> AllAddToCartBtns = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		
		int NumberOfBtns = AllAddToCartBtns.size();
		// generating random number 
		int RandomItem = rand.nextInt(0,NumberOfBtns);
		
		// for the pop-up dialogue box
		Thread.sleep(3000);
		
		// Adding a random item
		AllAddToCartBtns.get(RandomItem).click();
		
		// check the button status is remove 
		WebElement RemoveBtn = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
		String Remove = RemoveBtn.getText();
		assertEquals(Remove, RemoverButtonStatus);
		Thread.sleep(2000);
	}
	
	
	@Test(priority=5, enabled=true, invocationCount= 1)
	public void RemoveAddedItems() throws InterruptedException {
		
		// locating all Remove buttons 
		List <WebElement> AllRemoveBtns = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
		
		int NumberOfBtns = AllRemoveBtns.size();
		int RandomItem = rand.nextInt(0,NumberOfBtns);
		
		// Adding a random item
		AllRemoveBtns.get(RandomItem).click();
		
		// check the button status is AddToCart 
		WebElement AddToCartBtn = driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		String AddToCart = AddToCartBtn.getText();
		assertEquals(AddToCart, AddToCartButtonStatus);
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority=6, enabled=true)
	public void HappyCheckOutProcess() {
		
		// locating the Cart Icon Button 
		WebElement CartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		// Navigates to Your Cart page
		CartButton.click();
		
		// locating the CheckOut Button 
		WebElement CheckOutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
		// Navigates to Checkout Your Information
		CheckOutBtn.click();
		
		// Locating the First, Last Name, Zip Code Fields
		WebElement FirstNameFieldInput = driver.findElement(By.id("first-name"));
		WebElement LastNameFieldInput = driver.findElement(By.id("last-name"));
		WebElement ZipCodeFieldInput = driver.findElement(By.id("postal-code"));
		
		// locating the Continue Button
		WebElement ContinueBtn = driver.findElement(By.id("continue"));
		
		// filling in the required info
		FirstNameFieldInput.sendKeys(FirstName);
		LastNameFieldInput.sendKeys(LastName);
		ZipCodeFieldInput.sendKeys(ZipCode);
		
		//Navigates to Checkout: Overview Page
		ContinueBtn.click();
		
		// locating the Finish Button
		WebElement FinishBtn = driver.findElement(By.id("finish"));
		// placing the order
		FinishBtn.click();
		
		// Search for the confirmation message in the page
		boolean OrderConfirmationExist = driver.getPageSource().contains(OrderConfirmationMsg);
		Assert.assertEquals(OrderConfirmationExist,true);
		
		//String ActualOrderConfirmationMsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		//Assert.assertEquals(ActualOrderConfirmationMsg,ExpectedOrderConfirmationMsg);
	}
	
	
	@Test(priority=7, enabled=false)
	public void SadCheckOutProcess() {
		
		// locating the Cart Icon Button 
		WebElement CartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		// Navigates to Your Cart page
		CartButton.click();
		
		// locating the CheckOut Button 
		WebElement CheckOutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
		// Navigates to Checkout Your Information
		CheckOutBtn.click();
		
		// locating the Continue Button
		WebElement ContinueBtn = driver.findElement(By.id("continue"));
		
		//clicking on Continue with empty fields
		ContinueBtn.click();
		
		boolean ActualErrorMsg= driver.getPageSource().contains(EmptyFieldsErrorMsg);
		assertEquals(ActualErrorMsg, true);
	}
	

	@Test(priority=8, enabled=true)
	public void LogOut() throws InterruptedException {
		
		// ensure user is in products page
		driver.navigate().to(HomePageUrl);
		
		
		// Locating the Menu Button by id
		WebElement BurgerMenuBtn = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenuBtn.click();
		
		// Locating the LogOut Button 
		WebElement LogOutBtn = driver.findElement(By.id("logout_sidebar_link"));
		LogOutBtn.click();
		
		// Checking if it navigated back to Login Page 
		String ActualNavigatedPage = driver.getCurrentUrl();
		assertEquals(ActualNavigatedPage, LogInPage);
	}
	
	
	@AfterTest
	public void AfterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
