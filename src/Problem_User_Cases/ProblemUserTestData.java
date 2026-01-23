package Problem_User_Cases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProblemUserTestData {


WebDriver driver = new ChromeDriver();
	
	// LogIn Data
	String UserName = "problem_user";
	String Password = "secret_sauce";
	
	// Checkout Information 
	String FirstName = "Shahed";
	String LastName = "Atef";
	String ZipCode = "11280";
	
	String RemoverButtonStatus = "Remove";
	String AddToCartButtonStatus = "Add to cart";
	
	// Urls
	String HomePageUrl = "https://www.saucedemo.com/inventory.html";
	String LogInPage = "https://www.saucedemo.com/";
	
	// Random 
	Random rand  = new Random();
}
