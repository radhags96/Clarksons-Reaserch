package com.qa.clarksons.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.clarksons.factory.DriverFactory;
import com.qa.clarksons.pages.LoginPage;
import com.qa.clarksons.pages.SignUpPage;

public class BaseTest {

	protected WebDriver driver;
	protected DriverFactory df;

	protected Properties prop;
	
	protected SignUpPage signUpPage;
	protected LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.initPro();
		driver = df.initDriver(prop);		
		loginPage = new LoginPage(driver);
		signUpPage = new SignUpPage(driver);
		// homePage = new HomePage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
