package com.qa.clarksons.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.clarkson.constants.Constants;
import com.qa.clarksons.util.ElementsUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementsUtil eleUtil;
	private static final Logger log = LogManager.getLogger(SignUpPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(driver);
	}

	private By text = By.xpath("//div[text()='Registration Successful']");
	private By welComeText = By.xpath("//p[contains(text(),' Thank you for your applic')]");

	public void getLoginPage() {
		log.info(eleUtil.doElementGetText(text));
		log.info(eleUtil.doElementGetText(welComeText));
	}

}
