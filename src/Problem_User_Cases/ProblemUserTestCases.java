package Problem_User_Cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProblemUserTestCases extends ProblemUserTestData{
	
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
	    // ensuring that the next page navigated to is the HomePage
		Assert.assertEquals(NextPage, HomePageUrl);
	}
	
	@Test(priority=2, enabled=true, invocationCount= 2)
	public void AddingRandomItemsToCart() throws InterruptedException {
		
		// locating all AddToCart buttons 
		List <WebElement> AllAddToCartBtns = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
	    // obtaining all item's names
		List<WebElement> ItemNames = driver.findElements(By.className("inventory_item_name"));
		
		int NumberOfBtns = AllAddToCartBtns.size();
		
		// generating random number 
		int RandomItem = rand.nextInt(0,NumberOfBtns);
			
		// for the pop-up dialogue box
		Thread.sleep(2000);
					
		// store item name
		String SelectedItemName = ItemNames.get(RandomItem).getText();
			
		// click on selected item
		AllAddToCartBtns.get(RandomItem).click();
			
		// check the button status is remove 
		WebElement UpdatedButton = driver.findElements(By.cssSelector("button.btn_inventory")).get(RandomItem);
		String UpdatedButtonText = UpdatedButton.getText();
			
		//System.out.println(SelectedItemName);
			
		Thread.sleep(1000);
		Assert.assertEquals( UpdatedButtonText,
					RemoverButtonStatus, SelectedItemName + " Item was not added to cart");	
		
	}
	
	
	@Test(priority=3, enabled=true, invocationCount= 1)
	public void RemoveAddedItems() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// locating all Remove buttons 
		List <WebElement> AllRemoveBtns = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
		// obtaining all item's names
		List<WebElement> ItemNames = driver.findElements(By.className("inventory_item_name"));
		
		int NumberOfBtns = AllRemoveBtns.size();
		
		if (NumberOfBtns == 0 )
		{
			Assert.assertEquals( " No Remove Buttons were found", NumberOfBtns>0 );
		}
		else 
		{
		int RandomItem = rand.nextInt(0,NumberOfBtns);
				
		// for the pop-up dialogue box
		Thread.sleep(2000);
		
		// store item name
		String SelectedItemName = ItemNames.get(RandomItem).getText();
		// Adding a random item
		AllRemoveBtns.get(RandomItem).click();
				
		// check the button status is AddToCart 
		WebElement UpdatedButton = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).get(RandomItem);
		String UpdatedButtonText = UpdatedButton.getText();

		//System.out.println(SelectedItemName);
		
		Thread.sleep(1000);
				
		Assert.assertEquals( UpdatedButtonText,
				RemoverButtonStatus, SelectedItemName + " Item was not removed");
		}
	}
	
	

	@AfterTest
	public void AfterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
