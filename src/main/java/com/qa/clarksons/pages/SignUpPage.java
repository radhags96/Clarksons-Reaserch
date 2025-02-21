package com.qa.clarksons.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.clarkson.constants.Constants;
import com.qa.clarkson.constants.Errors;
import com.qa.clarksons.factory.DriverFactory;
import com.qa.clarksons.util.ElementsUtil;

public class SignUpPage {
	private WebDriver driver;
	private ElementsUtil eleUtil;
	private static final Logger log = LogManager.getLogger(SignUpPage.class);

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(driver);
	}

	private By continueBtn = By.xpath("//button[text()='Continue']");
	private By acknowledge = By.xpath("//div[contains(text(),'Yes please')]");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By businessEmail = By.xpath("(//input[@id='email'])[1]");
	private By phoneNum = By.xpath("(//input[@id='phoneNumber'])[1]");
	private By companyName = By.id("companyName");
	private By companyType = By.id("companyTypeId");
	private By city = By.xpath("(//input[@id='town'])[1]");
	private By country = By.xpath("//select[@id='country']");
	private By checkPhone = By.xpath("(//input[@id='marketingPreferencePhone'])[1]");
	private By signUpBtn = By.xpath("//div[text()=' Sign up ']");

	public String getSignUpPageUrl() {
		String url = eleUtil.waitForURLContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
		log.info("login page url==>" + url);
		
		return url;

	}

	public Exception signUpInvalidDetails() {
		eleUtil.clickElementWhenReady(continueBtn, 10);
		eleUtil.clickElementWhenReady(signUpBtn, 10);
		return new Exception(Errors.INVALID_DETAILS_FOUND_ERROR);
	}
	
	

	public LoginPage signUpDetails() {
		driver.navigate().refresh();
		eleUtil.waitForElementVisible(firstName, Constants.DEFAULT_TIME_OUT).sendKeys("Radha");
		eleUtil.doSendKeys(lastName, "Somashekhar");
		eleUtil.doSendKeys(businessEmail, "radhags@123");
		eleUtil.doSendKeys(phoneNum, "8904604116");
		eleUtil.doSendKeys(companyName, "Radha's Logistics");
		eleUtil.doSelectDropDownByVisibleText(companyType, "Logistics");
		eleUtil.doSendKeys(city, "Bengaluru");
		eleUtil.doSelectDropDownByVisibleText(country, "India");	
		WebElement Phone = eleUtil.waitForElementVisible(checkPhone, Constants.DEFAULT_TIME_OUT);
		Phone.click();
		String text = eleUtil.doElementGetText(acknowledge);
		log.info(text + " Phone");
		eleUtil.doClick(signUpBtn);
		return new LoginPage(driver);
	}
}
