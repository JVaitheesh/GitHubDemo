/**
 * 
 */
package com.orangeHRM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;

public class LoginPageTest {
	public WebDriver driver;//Declare WebDriver class
	LoginPage loginPage; //Declare LoginPage class since it is declared in both testcases.
	HomePage homepage; // Declare home page class object

	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium WebDrivers&Jars\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();// Already declared hence use this command
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
	}

	@Test // (invocationCount=2) this annotation is used for invoke the method
	public void verifyLogo()
	{
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
		//driver.quit();

	}

	@Test // (retryAnalyzer = MyRetry.class) implemented rerunning failed Test case
	public void verifyLogin()
	{
		// loginpage is  Reusability
		homepage=loginPage.login("Admin", "admin123") ;  //Make it as very Robust
		String currurl = driver.getCurrentUrl();
		String expurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(currurl, expurl);
		// Assert.fail(); Tested for rerunning failed Test case
		driver.quit();

	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	}
