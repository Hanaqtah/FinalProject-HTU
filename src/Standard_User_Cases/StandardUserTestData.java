package Standard_User_Cases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandardUserTestData {

WebDriver driver = new ChromeDriver();
	
	// LogIn Data
	String UserName = "standard_user";
	String Password = "secret_sauce";
	
	// Checkout Information 
	String FirstName = "Hala";
	String LastName = "Hanaqtah";
	String ZipCode = "11196";
	// Invalid field
	String EmptyFieldsErrorMsg= "Error: First Name is required";
	
	String ExpectedOrderConfirmationMsg = "Thank you for your order!";
	String OrderConfirmationMsg = "Thank you for your order!";
	
	String RemoverButtonStatus = "Remove";
	String AddToCartButtonStatus = "Add to cart";
	
	// Urls
	String HomePageUrl = "https://www.saucedemo.com/inventory.html";
	String LogInPage = "https://www.saucedemo.com/";
	
	// Random 
	Random rand  = new Random();
	
}
