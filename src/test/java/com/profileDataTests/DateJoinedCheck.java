package com.profileDataTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class DateJoinedCheck {
	WebDriver driver;
  @Test
  public void Verify_Date_Joined() throws  Exception {
	  
	  	LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
		 
		 ProfilePage.profileButton(driver).click();
		 String ActualValue=ProfilePage.getActualJoinDate(driver).getText();
		 assertEquals(ActualValue, "Sept. 8, 2021, 3:44 p.m.");
		 System.out.println("Test Case Verified Successfully");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }
  

  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }

}