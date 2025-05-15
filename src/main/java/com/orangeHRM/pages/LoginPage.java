package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	//Object repository  
	//And Variables and user action methods called functional encapsulation
	By username= By.name("username"); //Variables
	By password=By.xpath("//input[@placeholder='Password']");
    By loginBTN=By.xpath("//button[@type='submit']");
    By logo=By.xpath("//div[@class='orangehrm-login-branding']/img");
    
    public LoginPage(WebDriver driver) {  //initialize web driver by using constructor
    	this.driver=driver;
    }
    
    public boolean validateLogo() {                 //user action method
		driver.findElement(logo).isDisplayed();
		return true;
    }
		
		public HomePage login(String uname, String pswd) {  //user action method
			driver.findElement(username).sendKeys(uname);
			driver.findElement(password).sendKeys(pswd);
			//driver.findElement(username).sendKeys("Admin");// its hardcoded so we make it as robust 
			//driver.findElement(password).sendKeys("admin123");// its hardcoded so we make it as robust 
			driver.findElement(loginBTN).click();
			return new HomePage();//page chaining model    //  Land on home page class object
		}

	
		}
    
